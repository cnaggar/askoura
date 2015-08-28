package com.askoura.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.askoura.model.Customer;

public class CustomerDAO implements CustomerDAOInterface {

    private Session currentSession;

    private Transaction currentTransaction;

    public CustomerDAO() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        if(currentSession!=null)
        return currentSession;
        else return openCurrentSession();
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public int addCustomer(Customer entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    public void updateCustomer(Customer entity) {
        getCurrentSession().update(entity);
    }

    public Customer getCustomerById(int id) {
        Customer customer = (Customer) getCurrentSession().get(Customer.class, id);
        return customer;
    }

    public void removeCustomer(Customer entity) {
        getCurrentSession().delete(entity);
    }

    public void removeCustomer(int id) {
        Customer customer = (Customer) getCurrentSession().get(Customer.class, id);
        getCurrentSession().delete(customer);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listCustomers() {
        List<Customer> customers = (List<Customer>) getCurrentSession().createQuery("from Customer").list();
        System.out.println(customers.toString());
        return customers;
    }

    public void deleteAll() {
        List<Customer> entityList = listCustomers();
        for (Customer entity : entityList) {
            removeCustomer(entity);
        }
    }
}
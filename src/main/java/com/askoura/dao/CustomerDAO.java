package com.askoura.dao;


import java.util.List;

import org.hibernate.Session;

import com.askoura.model.Customer;

public class CustomerDAO implements CustomerDAOInterface {

    private Session currentSession;

    public CustomerDAO(Session tempSession) {
        currentSession = tempSession;
    }


    public int addCustomer(Customer entity) {
        return (Integer) currentSession.save(entity);
    }

    public void updateCustomer(Customer entity) {
        currentSession.update(entity);
    }

    public Customer getCustomerById(int id) {
        Customer customer = (Customer) currentSession.get(Customer.class, id);
        return customer;
    }

    public void removeCustomer(Customer entity) {
        currentSession.delete(entity);
    }

    public void removeCustomer(int id) {
        Customer customer = (Customer) currentSession.get(Customer.class, id);
        currentSession.delete(customer);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listCustomers() {
        List<Customer> customers = (List<Customer>) currentSession.createQuery("from Customer").list();
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
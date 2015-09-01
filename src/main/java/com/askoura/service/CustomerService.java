package com.askoura.service;

import java.util.List;

import com.askoura.dao.CustomerDAO;
import com.askoura.helper.SessionHelperInterface;
import com.askoura.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {

    private CustomerDAO customerDAO;
    private Transaction transaction;
    private SessionHelperInterface sessionHelper;

    public CustomerService(SessionHelperInterface sessionHelper) {
        this.sessionHelper = sessionHelper;
    }

    public int persist(Customer entity) {
        getSessionAndBeginTransaction();
        int temp = customerDAO.addCustomer(entity);
        commitTransaction();
        return temp;
    }

    public void update(Customer entity) {
        getSessionAndBeginTransaction();
        customerDAO.updateCustomer(entity);
        commitTransaction();
    }

    public Customer findById(int id) {
        getSessionAndBeginTransaction();
        Customer customer = customerDAO.getCustomerById(id);
        commitTransaction();
        return customer;
    }

    public void delete(int id) {
        getSessionAndBeginTransaction();
        customerDAO.removeCustomer(id);
        commitTransaction();
    }

    public List<Customer> findAll() {
        getSessionAndBeginTransaction();
        List<Customer> customers = customerDAO.listCustomers();
        commitTransaction();
        return customers;
    }

    public void deleteAll() {
        getSessionAndBeginTransaction();
        customerDAO.deleteAll();
        commitTransaction();

    }

    private void getSessionAndBeginTransaction(){
        Session session = sessionHelper.getCurrentSession();
        transaction = session.beginTransaction();
        customerDAO = new CustomerDAO(session);
    }
    private void commitTransaction(){
        transaction.commit();
    }

}
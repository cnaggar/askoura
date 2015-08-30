package com.askoura.service;

import java.util.List;

import com.askoura.dao.CustomerDAO;
import com.askoura.helper.SessionHelperInterface;
import com.askoura.model.Customer;
import com.askoura.helper.ProductionSessionHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {

    private CustomerDAO customerDAO;
    private Session session;
    private Transaction transaction;
    private SessionHelperInterface sessionHelper;

    public CustomerService(SessionHelperInterface sessionHelper) {
        this.sessionHelper = sessionHelper;
    }

    public int persist(Customer entity) {

        int temp = -1;
        OpenSessionAndBeginTransaction();
        temp = customerDAO.addCustomer(entity);
        commitTransactionAndCloseSession();
        return temp;
    }

    public void update(Customer entity) {
        OpenSessionAndBeginTransaction();
        customerDAO.updateCustomer(entity);
        commitTransactionAndCloseSession();
    }

    public Customer findById(int id) {
        OpenSessionAndBeginTransaction();
        Customer customer = customerDAO.getCustomerById(id);
        commitTransactionAndCloseSession();
        return customer;
    }

    public void delete(int id) {
        OpenSessionAndBeginTransaction();
        customerDAO.removeCustomer(id);
        commitTransactionAndCloseSession();
    }

    public List<Customer> findAll() {
        OpenSessionAndBeginTransaction();
        List<Customer> customers = customerDAO.listCustomers();
        commitTransactionAndCloseSession();
        return customers;
    }

    public void deleteAll() {
        OpenSessionAndBeginTransaction();
        customerDAO.deleteAll();
        commitTransactionAndCloseSession();

    }

    private void OpenSessionAndBeginTransaction(){
        session = sessionHelper.openCurrentSession();
        transaction = session.beginTransaction();
        customerDAO = new CustomerDAO(session);
    }
    private void commitTransactionAndCloseSession(){
        transaction.commit();
        session.close();
    }

    /*private void rollBackTransaction(){
        transaction.rollback();
        session.close();
    }*/

}
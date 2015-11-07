package com.askoura.service;

import java.util.List;

import com.askoura.dao.CustomerDAO;
import com.askoura.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;


    public int persist(Customer entity) {
        customerDAO.beginTransaction();
        int temp = customerDAO.addCustomer(entity);
        customerDAO.commitTransaction();
        return temp;
    }

    public void update(Customer entity) {
        customerDAO.beginTransaction();
        customerDAO.updateCustomer(entity);
        customerDAO.commitTransaction();
    }

    public Customer findById(int id) {
        customerDAO.beginTransaction();
        Customer customer = customerDAO.getCustomerById(id);
        customerDAO.commitTransaction();
        return customer;
    }

    public void delete(int id) {
        customerDAO.beginTransaction();
        customerDAO.removeCustomer(id);
        customerDAO.commitTransaction();
    }

    public List<Customer> findAll() {
        customerDAO.beginTransaction();
        List<Customer> customers = customerDAO.listCustomers();
        customerDAO.commitTransaction();
        return customers;
    }

    public void deleteAll() {
        customerDAO.beginTransaction();
        customerDAO.deleteAll();
        customerDAO.commitTransaction();

    }
}
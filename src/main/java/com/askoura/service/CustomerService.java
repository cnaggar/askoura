package com.askoura.service;

import java.util.List;

import com.askoura.dao.CustomerDAO;
import com.askoura.model.Customer;

public class CustomerService {

    private static CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public int persist(Customer entity) {
        int temp = 0;
        customerDAO.openCurrentSessionWithTransaction();
        temp = customerDAO.addCustomer(entity);
        customerDAO.closeCurrentSessionWithTransaction();
        return temp;
    }

    public void update(Customer entity) {
        customerDAO.openCurrentSessionWithTransaction();
        customerDAO.updateCustomer(entity);
        customerDAO.closeCurrentSessionWithTransaction();
    }

    public Customer findById(int id) {
        customerDAO.openCurrentSession();
        Customer customer = customerDAO.getCustomerById(id);
        System.out.println("Now: "+customer.toString());
        customerDAO.closeCurrentSession();
        return customer;
    }

    public void delete(int id) {
        customerDAO.openCurrentSessionWithTransaction();
        Customer customer = customerDAO.getCustomerById(id);
        customerDAO.removeCustomer(customer);
        customerDAO.closeCurrentSessionWithTransaction();
    }

    public List<Customer> findAll() {
        customerDAO.openCurrentSession();
        List<Customer> customers = customerDAO.listCustomers();
        customerDAO.closeCurrentSession();
        return customers;
    }

    public void deleteAll() {
        customerDAO.openCurrentSessionWithTransaction();
        customerDAO.deleteAll();
        customerDAO.closeCurrentSessionWithTransaction();
    }

    public CustomerDAO customerDAO() {
        return customerDAO;
    }
}
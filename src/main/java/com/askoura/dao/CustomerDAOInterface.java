package com.askoura.dao;

import java.util.List;

import com.askoura.model.Customer;

public interface CustomerDAOInterface {

    public int addCustomer(Customer p);
    public void updateCustomer(Customer p);
    public List<Customer> listCustomers();
    public Customer getCustomerById(int id);
    public void removeCustomer(int id);
}
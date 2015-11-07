package com.askoura.dao;


import java.util.List;

import org.hibernate.Session;

import com.askoura.model.Customer;

public class CustomerDAO extends AbstractDao implements CustomerDAOInterface {

    public int addCustomer(Customer entity) {
        return (Integer) getSession().save(entity);
    }

    public void updateCustomer(Customer entity) {
        getSession().update(entity);
    }

    public Customer getCustomerById(int id) {
        Customer customer = (Customer) getSession().get(Customer.class, id);
        return customer;
    }

    public void removeCustomer(int id) {
        Customer customer = (Customer) getSession().get(Customer.class, id);
        getSession().delete(customer);
    }

    public List<Customer> listCustomers() {
        List<Customer> customers = (List<Customer>) getSession().createQuery("from Customer").list();
        System.out.println(customers.toString());
        return customers;
    }

    public void deleteAll() {
        List<Customer> entityList = listCustomers();
        for (Customer entity : entityList) {
            removeCustomer(entity.getId());
        }
    }
}
package com.askoura.model;

import org.junit.Test;


import static org.assertj.core.api.StrictAssertions.assertThat;

public class CustomerTest {


    @Test
    public void equatingCustomers_simpleScenario_identicalCustomersAreEqual() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Amr Askoura");
        customer.setCountry("Egypt");
        customer.setId(1);
        Customer customer1 = new Customer();
        customer1.setName("Amr Askoura");
        customer1.setCountry("Egypt");
        customer1.setId(1);
        assertThat(customer1).isEqualTo(customer);

    }

    @Test
    public void equatingCustomers_simpleScenario_CustomersWithSameReferenceAreEqual() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Amr Askoura");
        customer.setCountry("Egypt");
        customer.setId(1);
        assertThat(customer).isEqualTo(customer);

    }

    @Test
    public void equatingNullCustomer_simpleScenario_returnsFalse() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Amr Askoura");
        customer.setCountry("Egypt");
        customer.setId(1);
        assertThat(customer).isNotEqualTo(null);

    }


    @Test
    public void equatingUnEqualCustomer_simpleScenario_returnsFalse() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Amr Askoura");
        customer.setCountry("Egypt");
        customer.setId(1);
        Customer customer1 = new Customer();
        customer1.setName("Amr Askoura");
        customer1.setCountry("Egypt");
        customer1.setId(2);
        assertThat(customer1).isNotEqualTo(customer);

    }
}
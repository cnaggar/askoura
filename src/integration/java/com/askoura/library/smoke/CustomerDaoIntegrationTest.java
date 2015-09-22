package com.askoura.library.smoke;

import com.askoura.model.Customer;
import com.askoura.service.CustomerService;
import com.askoura.travis.TestConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConf.class})
public class CustomerDaoIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void add_a_customer_to_the_db() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Amr Askoura");
        customer.setCountry("Egypt");
        // When
        customerService.persist(customer);
        // Then
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);

    }

    @Test
    public void edit_customer() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Cherig Naggar");
        customer.setCountry("Kanadah");
        customerService.persist(customer);
        Customer original = new Customer(customer);
        customer.setName("Cherig Naggar1");
        customer.setCountry("Kanadah");

        // When
        customerService.update(customer);
        // Then
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);
        assertThat(customers).doesNotContain(original);

    }

    @Test
    public void find_by_id() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Mina Sameer");
        customer.setCountry("India");
        int index = customerService.persist(customer);
        // When
        Customer fetchedCustomer= customerService.findById(index);
        // Then
        assertThat(fetchedCustomer).isEqualTo(customer);

    }

    @Test
    public void delete_all() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Mina Sameer");
        customer.setCountry("India");
        customerService.persist(customer);
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);
        assertThat(customers).isNotEmpty();

        // When
        customerService.deleteAll();
        // Then
        List<Customer> customers1= customerService.findAll();
        assertThat(customers1).isEmpty();

    }

    @Test
    public void delete_by_id() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Mina Sameer");
        customer.setCountry("India");
        int index = customerService.persist(customer);
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);
        assertThat(customers).isNotEmpty();

        // When
        customerService.delete(index);
        // Then
        List<Customer> customers1= customerService.findAll();
        assertThat(customers1).doesNotContain(customer);

    }

}

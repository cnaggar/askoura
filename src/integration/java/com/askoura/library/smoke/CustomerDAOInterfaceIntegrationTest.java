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
public class CustomerDAOInterfaceIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void addCustomer_simpleScenario_customerAddedToDB() throws Exception {
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
    public void editCustomer_simpleScenario_customerEditedInDB() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Cherig Naggar");
        customer.setCountry("Kanadah");
        // When
        customerService.persist(customer);
        Customer original = new Customer(customer);
        customer.setName("Cherig Naggar1");
        customer.setCountry("Kanadah");
        customerService.update(customer);
        // Then
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);
        assertThat(customers).doesNotContain(original);

    }

    @Test
    public void getCustomerByID_simpleScenario_customerFetchedFromDB() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Mina Sameer");
        customer.setCountry("India");
        // When
        int index = customerService.persist(customer);
        // Then
        Customer fetchedCustomer= customerService.findById(index);
        assertThat(fetchedCustomer).isEqualTo(customer);

    }

    @Test
    public void deleteAllAfterAdding_DBEmptied() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Mina Sameer");
        customer.setCountry("India");
        // When
        customerService.persist(customer);
        // Then
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);
        assertThat(customers).isNotEmpty();

        customerService.deleteAll();
        List<Customer> customers1= customerService.findAll();
        assertThat(customers1).isEmpty();

    }

    @Test
    public void deleteByIDAfterAdding_ObjectRemoved() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Mina Sameer");
        customer.setCountry("India");
        // When
        int index = customerService.persist(customer);
        // Then
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);
        assertThat(customers).isNotEmpty();

        customerService.delete(index);
        List<Customer> customers1= customerService.findAll();
        assertThat(customers1).doesNotContain(customer);

    }

}

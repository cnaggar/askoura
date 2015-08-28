package com.askoura.library.smoke;

import com.askoura.dao.CustomerDAOInterface;
import com.askoura.helper.DBHelper;
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

    private CustomerService customerService;

    @Test
    public void addCustomer_simpleScenario_customerAddedToDB() throws Exception {
        // Given the customers is not in the DB and
        Customer customer = new Customer();
        customer.setName("Amr Askoura");
        customer.setCountry("Egypt");
        customerService = new CustomerService();

        // When
        customerService.persist(customer);
        // Then
        List<Customer> customers= customerService.findAll();
        assertThat(customers).contains(customer);

    }

}

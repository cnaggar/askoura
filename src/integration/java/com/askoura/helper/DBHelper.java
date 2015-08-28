package com.askoura.helper;

import java.util.List;

import com.askoura.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

public class DBHelper {

    private JdbcTemplate jdbcTemplate;

    public DBHelper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteStation(String name, Long groupId) {
        jdbcTemplate.update("DELETE FROM station WHERE name = ? AND pgroup_id = ?", new Object[]{name, groupId});

    }

    public List<Integer> getAllOfA() {
        return jdbcTemplate.queryForList("select * from A", Integer.class);
    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.queryForList("select * from Customer", Customer.class);
    }
}
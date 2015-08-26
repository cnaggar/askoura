package com.askoura.travis;

import org.springframework.jdbc.core.JdbcTemplate;

public class TravisCIVerifier {
    
    private JdbcTemplate jdbcTemplate;

    public TravisCIVerifier(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean returnWhatYouGet(boolean input) {
        return input;
    }

    public int onlyInIntegrationSum(int a, int b) {
        return a + b;
    }

    public void insertIntoTableA(int someInteger) {
        jdbcTemplate.update("insert into A(I) values(?)", someInteger);
    }
}

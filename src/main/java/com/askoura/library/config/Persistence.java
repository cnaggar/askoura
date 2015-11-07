package com.askoura.library.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Persistence {

    @Bean(name = "prodDs")
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.h2.jdbcx.JdbcDataSource");
        ds.setUsername("");
        ds.setPassword("");
        ds.setJdbcUrl("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE");

        return ds;
    }
}
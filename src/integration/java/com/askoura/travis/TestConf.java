package com.askoura.travis;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.askoura.helper.DBHelper;

@Configuration
public class TestConf {
    
    @Bean(name = "embeddedDs")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("askoura.sql").build();
    }

    @Bean(name = "testJdbc")
    public JdbcTemplate jdbcTemplate(@Qualifier("embeddedDs") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DBHelper dbHelper(@Qualifier("testJdbc") JdbcTemplate jdbcTemplate) {
        return new DBHelper(jdbcTemplate);
    }

    @Bean
    public TravisCIVerifier travisCIVerifier(@Qualifier("testJdbc") JdbcTemplate jdbcTemplate) {
        return new TravisCIVerifier(jdbcTemplate);
    }
}

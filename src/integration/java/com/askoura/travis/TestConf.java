package com.askoura.travis;

import javax.sql.DataSource;

import com.askoura.helper.SessionHelperInterface;
import com.askoura.service.CustomerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import com.askoura.helper.DBHelper;
import com.askoura.helper.TestSessionHelper;

@Configuration
public class TestConf {

    @Bean(name = "embeddedDs")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("askoura.sql").build();
    }

    @Bean
    public CustomerService customerService(@Qualifier("testSessionHelper")SessionHelperInterface sessionHelper) {
        return new CustomerService(sessionHelper);
    }

    @Bean(name = "testSessionHelper")
    public SessionHelperInterface sessionHelper() {
        return new TestSessionHelper();
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

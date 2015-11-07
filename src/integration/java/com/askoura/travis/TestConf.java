package com.askoura.travis;

import javax.sql.DataSource;

import com.askoura.dao.CustomerDAO;
import com.askoura.model.Customer;
import com.askoura.service.CustomerService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import com.askoura.helper.DBHelper;

import java.util.Properties;

@Configuration
public class TestConf {

    @Bean(name = "embeddedDs")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("askoura.sql").build();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    public CustomerDAO customerDAO() {
        return new CustomerDAO();
    }


    @Bean(name = "testJdbc")
    public JdbcTemplate jdbcTemplate(@Qualifier("embeddedDs") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory(){
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.current_session_context_class", "thread");
        prop.setProperty("hibernate.connection.pool_size", "1");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");

        org.hibernate.cfg.Configuration configuration =  new org.hibernate.cfg.Configuration()
                .addProperties(prop).addAnnotatedClass(Customer.class);
        try {
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            return configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
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

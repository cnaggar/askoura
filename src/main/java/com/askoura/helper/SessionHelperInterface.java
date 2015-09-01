package com.askoura.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public interface SessionHelperInterface {

    public SessionFactory getSessionFactory();
    public Session getCurrentSession();
}

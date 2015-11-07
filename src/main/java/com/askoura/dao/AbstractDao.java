package com.askoura.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aaskoura on 11/7/15.
 */
public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Transaction trx;


    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void beginTransaction() {
        trx =  sessionFactory.getCurrentSession().beginTransaction();
    }

    public void rollbackTransaction() {
        trx.rollback();
    }

    public void commitTransaction() {
        trx.commit();
    }

}
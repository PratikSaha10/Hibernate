package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Users;


public class CreateUsers{
    private SessionFactory sessionFactory;

    public CreateUsers(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

       // create objects of User class
        Users users = new Users("user1", "1234a", "abc123@gmail.com", "CUSTOMER" );
        session.persist(users);
        users = new Users("user2", "1234", "123@gmail.com", "CUSTOMER" );
        session.persist(users);
        //commit
        session.getTransaction().commit();
        // lose
        session.close();
        System.out.println("User created successfully with id "+users.getUserid());
    }
}


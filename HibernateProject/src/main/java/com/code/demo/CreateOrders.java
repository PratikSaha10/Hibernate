package com.code.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Orders;
import com.code.entity.Users;
import java.time.LocalDateTime;

public class CreateOrders{
	private SessionFactory sessionFactory;
	  public CreateOrders(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	        Session session = sessionFactory.getCurrentSession();
	        session.beginTransaction();

        // Fetch an existing user
        int userid = 4;  
        Users user = session.get(Users.class, userid);

        if (user== null) {
        	System.out.println("User not found!");
        }
        // Create and Insert Order
        // Start with totalAmount = 0, cause total amount will updated when orderdetailes are added
        else{
        	Orders order = new Orders(LocalDateTime.now(), 0, user);
        session.persist(order);
        //order = new Orders(LocalDateTime.now(), 0, user);
        //session.persist(order);

        session.getTransaction().commit();
        session.close();
        System.out.println("Order created successfully with id: " +order.getOrderId());
        }

        
    }
}

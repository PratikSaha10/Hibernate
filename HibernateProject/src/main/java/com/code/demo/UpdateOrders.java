package com.code.demo;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.Orders;
import com.code.entity.Product;
import com.code.entity.Users;


public class UpdateOrders {
    private SessionFactory sessionFactory;

    public UpdateOrders(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int orderid=5;
        Orders orders = session.get(Orders.class, orderid);
        if(orders==null) {
    		System.out.println("sorry no order found with id "+ orderid);
    		return;
    	}
        System.out.println("Orderid:"+ orders.getOrderId());
    	System.out.println("Date:"+ orders.getOrderDate());
    	System.out.println("TotalAmount: "+ orders.getTotalAmount());
    	System.out.println("UserId: "+ orders.getUser().getUsername());
    	//update using setters
    	//orders.setOrderDate(LocalDateTime.now());
    	orders.setTotalAmount(0.0);
    	//update changes to db
    	session.merge(orders);
    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("Order updated successfully ");
    }
}

package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.Orders;
import com.code.entity.Users;


public class DeleteOrders {
    private SessionFactory sessionFactory;

    public DeleteOrders(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int orderid=1;
        Orders orders= session.get(Orders.class, orderid);
        
        if(orders==null) {
    		System.out.println("sorry no order found with id "+orderid);
    		return;
    	}
        System.out.println("Orderid:"+ orders.getOrderId());
        System.out.println("Date:"+ orders.getOrderDate());
    	System.out.println("TotalAmount: "+ orders.getTotalAmount());
    	System.out.println("UserId: "+ orders.getUser().getUsername());
    	//delete the object from database
    	session.remove(orders);
    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("order deleted successfully");
    }
}

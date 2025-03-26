package com.code.demo;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Product;
import com.code.entity.Users;


public class UpdateOrdersDetails {
    private SessionFactory sessionFactory;

    public UpdateOrdersDetails(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int orderDetailId=3;
        OrderDetails orderDetails = session.get(OrderDetails.class, orderDetailId);
        if(orderDetails==null) {
    		System.out.println("sorry no orderdeatil found with id "+ orderDetailId);
    		return;
    	}
        System.out.println("Orer Id: "+ orderDetails.getOrder().getOrderId());
        System.out.println("Product Id: "+ orderDetails.getProduct().getProductid());
    	System.out.println("Quantity:"+ orderDetails.getQuantity());
    	System.out.println("UnitPrice: "+ orderDetails.getUnitPrice());
    	
    	 // Set the OrderDetails ID want to update
        int newQuantity = 5; // New quantity
        // Calculate new total amount 
        double newTotalAmount = newQuantity * orderDetails.getProduct().getPrice();
        // Update fields
        orderDetails.setQuantity(newQuantity);
        //orderDetails.setUnitPrice(newUnitPrice);
        session.merge(orderDetails);
        // Update totalAmount in the related Order
        Orders order = orderDetails.getOrder();
        order.setTotalAmount(newTotalAmount);
        session.merge(order);

    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("OrderDetails updated successfully ");
    }
}

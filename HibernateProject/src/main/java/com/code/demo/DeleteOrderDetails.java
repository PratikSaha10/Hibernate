package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Users;


public class DeleteOrderDetails {
    private SessionFactory sessionFactory;

    public DeleteOrderDetails(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int orderdetailid=4;
        OrderDetails orderDetails= session.get(OrderDetails.class, orderdetailid);
        
        if(orderDetails==null) {
    		System.out.println("sorry no orderdetail found with id "+orderdetailid);
    		return;
    	}
        System.out.println("OrerDetail Id: "+ orderdetailid);
        System.out.println("Orer Id: "+ orderDetails.getOrder().getOrderId());
        System.out.println("Product Id: "+ orderDetails.getProduct().getProductid());
    	System.out.println("Quantity:"+ orderDetails.getQuantity());
    	System.out.println("UnitPrice: "+ orderDetails.getUnitPrice());
    	
    	//delete the object from database
    	session.remove(orderDetails);
    	//if the orderdetail is deleted then total amount in orders table will be 0
    	Orders orders = orderDetails.getOrder();
    	orders.setTotalAmount(0);
    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("order deleted successfully");
    }
}

package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Product;

public class CreateOrderDetails {
	private SessionFactory sessionFactory;
	public CreateOrderDetails(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	    Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	     
        int orderId = 6;   //order id
        int productId = 7; //product id
        int quantity = 2;  //quantity

        Orders order = session.get(Orders.class, orderId);
        Product product = session.get(Product.class, productId);

        if (order != null && product != null) {
            // Create OrderDetails entry
            OrderDetails orderDetails = new OrderDetails(quantity, product.getPrice(), order, product);
            session.persist(orderDetails);

            // Update total amount in the Order
            order.setTotalAmount(order.getTotalAmount() + (quantity * product.getPrice()));
            session.persist(orderDetails);

            session.getTransaction().commit();
            System.out.println("OrderDetails added successfully with id: "+ orderDetails.getId());
        } else {
            System.out.println("Order or Product not found!");
        }

        session.close();
    }
}

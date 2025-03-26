package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.Product;


public class UpdateProduct {
    private SessionFactory sessionFactory;

    public UpdateProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int productid=10;
        Product product = session.get(Product.class, productid);
        if(product==null) {
    		System.out.println("sorry no product found with id "+ productid);
    		return;
    	}
    	System.out.println("Name :"+ product.getName());
    	System.out.println("Price: "+ product.getPrice());
    	System.out.println("stockQuantity: "+ product.getStockQuantity());
    	//update using setters
    	product.setName("Cricket bat");
    	product.setPrice(5000);
    	product.setStockQuantity(500);
    	//update changes to db
    	session.merge(product);
    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("Product updated successfully ");
    }
}

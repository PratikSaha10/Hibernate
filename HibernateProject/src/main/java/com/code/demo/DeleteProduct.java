package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.Product;


public class DeleteProduct {
    private SessionFactory sessionFactory;

    public DeleteProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int prductid=11;
        Product product= session.get(Product.class, prductid);
        if(product==null) {
    		System.out.println("sorry no product found with id "+ product);
    		return;
    	}
    	System.out.println("Name :"+ product.getName());
    	System.out.println("Price: "+ product.getPrice());
    	System.out.println("stockQuantity: "+ product.getStockQuantity());
    	//delete the object from database
    	session.remove(product);
    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("Product deleted successfully");
    }
}

package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Product;
import com.code.entity.Category;


public class CreateProduct {
    private SessionFactory sessionFactory;

    public CreateProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int catid=7;
        Category category = session.get(Category.class, catid);
        /*Product product= new Product();
        if (category != null) {
            product = new Product("Jersys",200, 500, category);
            session.persist(product);
        } else {
            System.out.println("Category not found!");
        }*/
        
        if(category==null) {
    		System.out.println("sorry no category found with id "+category);
    		return;
    	}
    	System.out.println("Name :"+ category.getName());
    	System.out.println("Description: "+ category.getDescription());
    	//create the object of course
    	Product product = new Product("Football Boots", 1000, 250, category);
    	//save the object
    	session.persist(product);

        session.getTransaction().commit();
        session.close();
        System.out.println("Product inserted successfully with id "+ product.getProductid());
    }
}

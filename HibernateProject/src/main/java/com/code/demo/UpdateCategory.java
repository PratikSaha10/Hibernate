package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;


public class UpdateCategory {
    private SessionFactory sessionFactory;

    public UpdateCategory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int catid=4;
        Category category = session.get(Category.class, catid);
        if(category==null) {
    		System.out.println("sorry no category found with id "+category);
    		return;
    	}
    	System.out.println("Name :"+ category.getName());
    	System.out.println("Description: "+ category.getDescription());
    	//update using setters
    	category.setDescription("Author: Bibhutibhushan Bandyopadhyay");
    	//update using merge()
    	session.merge(category);
    	//commit
        session.getTransaction().commit();
        //close
        session.close();
        System.out.println("category updated successfully ");
    }
}

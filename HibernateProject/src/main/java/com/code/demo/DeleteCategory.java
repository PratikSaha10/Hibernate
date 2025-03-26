package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;


public class DeleteCategory {
    private SessionFactory sessionFactory;

    public DeleteCategory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int catid=5;
        Category category = session.get(Category.class, catid);
        if(category==null) {
    		System.out.println("sorry no category found with id "+category);
    		return;
    	}
    	System.out.println("Name :"+ category.getName());
    	System.out.println("Description: "+ category.getDescription());
    	//delete the object from database
    	session.remove(category);
    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("category deleted successfully");
    }
}

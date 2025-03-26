package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.Users;


public class UpdateUsers {
    private SessionFactory sessionFactory;

    public UpdateUsers(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int userid=2;
        Users users = session.get(Users.class, userid);
        if(users==null) {
    		System.out.println("sorry no users found with id "+users);
    		return;
    	}
    	System.out.println("Name :"+ users.getUsername());
    	System.out.println("Password: "+ users.getPassword());
    	System.out.println("Email: "+ users.getEmail());
    	System.out.println("Role: "+ users.getRole());
    	//update using setters
    	users.setUsername("user3");
    	users.setPassword("xyz");
    	users.setEmail("b@gmail.com");
    	users.setRole("CUSTOMER");
    	//update using merge()
    	session.merge(users);
    	//commit
        session.getTransaction().commit();
        //close
        session.close();
        System.out.println("User updated successfully ");
    }
}

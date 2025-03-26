package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.Users;


public class DeleteUsers {
    private SessionFactory sessionFactory;

    public DeleteUsers(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int userid=1;
        Users users = session.get(Users.class, userid);
        if(users==null) {
    		System.out.println("sorry no category found with id "+users);
    		return;
    	}
    	System.out.println("User Id :"+ users.getUserid());
    	System.out.println("Username: "+ users.getUsername());
    	System.out.println("Email: "+ users.getEmail());
    	System.out.println("Role: "+ users.getRole());
    	//delete the object from database
    	session.remove(users);
    	//commit
        session.getTransaction().commit();
        session.close();
        System.out.println("User deleted successfully");
    }
}

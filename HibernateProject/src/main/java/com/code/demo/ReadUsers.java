package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;
import com.code.entity.Users;

public class ReadUsers {
private SessionFactory sessionFactory;
//constructor with parameter
public ReadUsers(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	//create the Session Object
	Session session=sessionFactory.getCurrentSession();
	//start the transaction
	session.beginTransaction();
	//create the query to get all the objects of category
List<Users> users= session.createQuery("from Users").getResultList();
if(users.size()==0) {
	System.out.println("No Record Found");
	return;
}
//read one by one object from the list
for(Users user:users)
{
	System.out.println(user.toString());
}
//close the session
session.close();
}
}

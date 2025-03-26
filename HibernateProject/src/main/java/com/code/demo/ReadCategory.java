package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;

public class ReadCategory {
private SessionFactory sessionFactory;
//constructor with parameter
public ReadCategory(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	//create the Session Object
	Session session=sessionFactory.getCurrentSession();
	//start the transaction
	session.beginTransaction();
	//create the query to get all the objects of category
List<Category> categories= session.createQuery("from Category").getResultList();
if(categories.size()==0) {
	System.out.println("No Record Found");
	return;
}
//read one by one object from the list
for(Category category:categories)
{
	System.out.println(category.toString());
}
//close the session
session.close();
}
}

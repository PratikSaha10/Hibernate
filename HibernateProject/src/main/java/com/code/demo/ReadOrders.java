package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;
import com.code.entity.Orders;
import com.code.entity.Users;

public class ReadOrders {
private SessionFactory sessionFactory;
//constructor with parameter
public ReadOrders(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	//create the Session Object
	Session session=sessionFactory.getCurrentSession();
	//start the transaction
	session.beginTransaction();
	//create the query to get all the objects of category
List<Orders> orders= session.createQuery("from Orders").getResultList();
if(orders.size()==0) {
	System.out.println("No Record Found");
	return;
}
//read one by one object from the list
for(Orders order:orders)
{
	System.out.println(order.toString());
}
//close the session
session.close();
}
}

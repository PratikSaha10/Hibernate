package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;
import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Users;

public class ReadOrderDetails {
private SessionFactory sessionFactory;
//constructor with parameter
public ReadOrderDetails(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	//create the Session Object
	Session session=sessionFactory.getCurrentSession();
	//start the transaction
	session.beginTransaction();
	//create the query to get all the objects of category
List<OrderDetails> orderDetails= session.createQuery("from OrderDetails").getResultList();
if(orderDetails.size()==0) {
	System.out.println("No Record Found");
	return;
}
//read one by one object from the list
for(OrderDetails orderDetail:orderDetails)
{
	System.out.println(orderDetail.toString());
}
//close the session
session.close();
}
}

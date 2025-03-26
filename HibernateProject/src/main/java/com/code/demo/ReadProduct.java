package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;
import com.code.entity.Product;

public class ReadProduct {
private SessionFactory sessionFactory;
//constructor with parameter
public ReadProduct(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	//create the Session Object
	Session session=sessionFactory.getCurrentSession();
	//start the transaction
	session.beginTransaction();
	//create the query to get all the objects of product
List<Product> products= session.createQuery("from Product").getResultList();
if(products.size()==0) {
	System.out.println("No Record Found");
	return;
}
//read one by one object from the list
for(Product product: products)
{
	System.out.println(product.toString());
}
//close the session
session.close();
}
}

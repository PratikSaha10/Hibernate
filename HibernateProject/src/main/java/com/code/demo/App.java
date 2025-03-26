package com.code.demo;

import javax.sound.midi.Instrument;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.entity.Category;
import com.code.entity.Product;
import com.code.entity.Users;
import com.code.entity.Orders;
import com.code.entity.OrderDetails;

public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        
    	//create the object configuration class
    	//configure the hibernateconfig xml file
    	//annotate each to to the configure
    	//call the method buildSessionFactory
    	//returns the object of Sessionfactory
 SessionFactory sessionFactory=   new Configuration()
    			.configure("hibernate.cfg.xml")
    			.addAnnotatedClass(Category.class)
    			.addAnnotatedClass(Product.class)
    			.addAnnotatedClass(Users.class)
    			.addAnnotatedClass(Orders.class)
    			.addAnnotatedClass(OrderDetails.class)
    			.buildSessionFactory();
//new CreateCategory(sessionFactory);
//new ReadCategory(sessionFactory);
//new UpdateCategory(sessionFactory);
//new DeleteCategory(sessionFactory);
//new CreateProduct(sessionFactory); 
//new ReadProduct(sessionFactory); 
//new UpdateProduct(sessionFactory);
//new DeleteProduct(sessionFactory);
//new CreateUsers(sessionFactory);
//new ReadUsers(sessionFactory);
//new UpdateUsers(sessionFactory);
//new DeleteUsers(sessionFactory);
//new CreateOrders(sessionFactory);
//new ReadOrders(sessionFactory);
//new UpdateOrders(sessionFactory);
//new DeleteOrders(sessionFactory);
//new CreateOrderDetails(sessionFactory);
 //new ReadOrderDetails(sessionFactory);
// new UpdateOrdersDetails(sessionFactory);
 //new DeleteOrderDetails(sessionFactory);
    }
}






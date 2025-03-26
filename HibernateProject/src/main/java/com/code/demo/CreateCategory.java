/*package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;
import com.code.entity.Product;

//import com.code.entity.Instructor;
//import com.code.entity.InstructorProfile;

public class CreateCategory {
private SessionFactory sessionFactory=null;
//constructor with SessionFactory Object
public CreateCategory(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	//create the session object
	Session session=sessionFactory.getCurrentSession();
	//start the transaction
	session.beginTransaction();
	//create object of category & save the object 
	Category category=new Category("Books", "Books of all genres");
	session.persist(category);
	//create the object of product & save the object 
	Product product=new Product("Mountain of The Moon", 200,100, category);
	session.persist(product);

	//commit
	session.getTransaction().commit();
	//close session object
	session.close();
	//message
	System.out.println("category is created Successfully with id "+category.getCatid());
	
	
	
}
}*/

package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Category;
import com.code.entity.Product;


public class CreateCategory {
    private SessionFactory sessionFactory;

    public CreateCategory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

       // Insert Categories
        Category category = new Category("Electronics", "Electronic devices");
        session.persist(category);
        
        category = new Category("Sports", "All sports kits");
        session.persist(category);

        session.getTransaction().commit();
        session.close();
        System.out.println("Categories created successfully with id "+category.getCatid());
    }
}


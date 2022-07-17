package com.hibernate.HibernateAnnotation;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Address add1 = new Address();
    
    	add1.setStreet("Shivaji Peth");
    	add1.setCity("Kolhapur");
    	add1.setOpen(false);
    	add1.setX(2110.9597);
    	add1.setAddDate(new Date());
    	
    	Address add2 = new Address();
    	
    	add2.setStreet("Hindvi Peth");
    	add2.setCity("Khochi");
    	add2.setOpen(true);
    	add2.setX(2110.9597);
    	add2.setAddDate(new Date());
    	
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	
    	Session session = factory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(add1);
    	session.save(add2);
    	
    	Query q = session.createQuery("from Address");
    	List<Address> l = q.list();
    	for(Address a : l)
    		System.out.println(a);
    	    	
    	tx.commit();
    	session.close();
    	factory.close();
    }
}

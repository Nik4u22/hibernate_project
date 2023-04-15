package com.analyticssakha.hibernate_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate project!" );
        
        /*
        Configuration conf = new Configuration();
        // Automatically detects hibernate config file, if not then provide file name or file path also
        conf.configure("hibernate.cfg.xml"); 
        SessionFactory factory = conf.buildSessionFactory();
         */
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        //System.out.println(factory);
        //System.out.println(factory.isClosed());
        //System.out.println(factory.getCurrentSession());
        
        //Create employee object
        Employee emp1 = new Employee();
        emp1.setId(100);
        emp1.setFirstName("Nikhil");
        emp1.setLastName("Jagnade");
        emp1.setEmail("nikhiljagnade22@gmail.com");
        System.out.println(emp1);
        
        //Create session object - get current session instance
        Session session = factory.getCurrentSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.save(emp1);
        
        transaction.commit();
        
        session.close();
        
    }
}

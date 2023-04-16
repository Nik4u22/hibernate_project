package com.analyticssakha.hibernate_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
	public static void main( String[] args ) throws IOException, ParseException
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
        Employee employee = new Employee();
        employee.setId(100);
        employee.setSalary(50000);
        System.out.println(employee);
        
        //Create person object
        Person person = new Person();
        person.setId(1);
        person.setFirstName("Nikhil");
        person.setLastName("Jagnade");
        person.setGender('M');
        
        // Date object to convert string to date object
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        Date date_of_birth = simpleDateFormat.parse("21/01/1992");
        person.setDateofbirth(date_of_birth);
        person.setEmail("nikhiljagnade22@gmail.com");
        
        // Calculate age in years
        LocalDate today = LocalDate.now(); // Today's date is 10th Jan 2022
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateTimeFormatter = dateTimeFormatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
    	LocalDate birthday = LocalDate.parse("21/01/1992", dateTimeFormatter);// Birth date

    	Period p = Period.between(birthday, today);
    	// Now access the values as below
    	//System.out.println(p.getDays());    //9
    	//System.out.println(p.getMonths());  //0
    	//System.out.println(p.getYears());   //42
    	int age = p.getYears();
    	person.setAge(age);
        
    	person.setContactno("8983668615");
    	person.setAddress("Flat.NO. 1157, Lodha Heritage, Bandra West");
    	person.setCity("Mumbai");
    	person.setState("Maharashtra");
    	person.setCountry("India");
    	person.setPincode("400050");
    	
    	// Read image file using fileinputstream
		FileInputStream fileInputStream = new FileInputStream("/Users/nik4u/eclipse-workspace/hibernate_project/src/main/java/avtar.jpeg");
        byte[] image_data = new byte[fileInputStream.available()];
        fileInputStream.read(image_data);
        fileInputStream.close();
        person.setAvtar(image_data);
        
        // Date object to get current date
        Date current_date = new Date();
        person.setDateadded(current_date);
        
        
        //Create session object - get current session instance
        Session session1 = factory.getCurrentSession();
        
        // Transaction object require only to save data
        Transaction transaction = session1.beginTransaction();
        
        // Save objects - save() deprecated so use persist()
        //session1.save(employee);
        //session1.persist(employee);
        //session1.save(person);
        //session1.persist(employee);
        
        transaction.commit();
                
        session1.close();
        
        //Get data from table
        // Change <property name="hbm2ddl.auto">update</property>
        Session session2 = factory.openSession();
        
        //get() - return null if object not found in chache as well as on database
        
        Employee employee_obj = (Employee)session2.get(Employee.class,100);
        //System.out.println(employee_obj);
        
        Person person_obj = (Person)session2.get(Person.class,1);
        //System.out.println(person_obj);
        //System.out.println(person_obj.getFirstName());
        //System.out.println(person_obj.getLastName());
        
        session2.close();
        
        factory.close();
        
    }
    
    
    // Method to calculate age
    public int calculate_age(String date_of_birth) {
    
    	LocalDate today = LocalDate.now(); // Today's date is 10th Jan 2022
    	LocalDate birthday = LocalDate.parse("21-01-1992");// Birth date

    	Period p = Period.between(birthday, today);
    	// Now access the values as below
    	//System.out.println(p.getDays());    //9
    	//System.out.println(p.getMonths());  //0
    	//System.out.println(p.getYears());   //42
    	int age = p.getYears();
		return age;

    }
    
 
    
}

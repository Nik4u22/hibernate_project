package com.analyticssakha.hibernate_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        
        //Create company object
        Company company = new Company();
        company.setName("Infosys Ltd");
        company.setAddress("N 403. 405 North Block, 4th Floor, Manipal Centre, Near-Syndicate Bank, Mahatma Gandhi Road, Dickenson Road");
        company.setCity("Bangaluru");
        company.setState("Karnataka");
        company.setCountry("India");
        company.setPincode("560042");
        company.setContactno("8025592088"); 
        company.setEmail("contact@infosys.co.in");
        //company.setEmployee(null);
        
        //Create person object
        Person person = new Person();
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
        
        
        //Create employee object
        Employee employee = new Employee();
        employee.setSalary(50000);
        
        Education education = new Education();
        education.setDegree_name("B.Tech");
        education.setSpecialization("Information Technology");
        education.setDuration("4 years");
        education.setPassing_year("2014");
        
        //employee.setEducation(new Education("B.Tech","Information Technology", "4 Years", "2014"));
        employee.setEducation(education);
       
        // Set personid in employee
        employee.setPerson(person);
        
        // Set employeeid in employee
        employee.setCompany(company);
        System.out.println(employee);
        
        // Create project object
        Project p1 = new Project();
        p1.setProjectName("iLibrary");
        Project p2 = new Project();
        p2.setProjectName("Fnnone");
        
        List<Project> projectList = new ArrayList<Project>();
        projectList.add(p1);
        projectList.add(p2);
        
        //Set projects to employee
        employee.setProjects(projectList);
        
        //Create session object - get current session instance
        Session session1 = factory.getCurrentSession();
        
        // Transaction object require only to save data
        Transaction transaction = session1.beginTransaction();
        
        // Save objects - save() deprecated so use persist()
        session1.save(company);
        session1.save(person);
        session1.save(p1);
        session1.save(p2);
        session1.save(employee);
        
        transaction.commit();
                
        session1.close();
        
        //Get data from table - Eager Loading
        // Change <property name="hbm2ddl.auto">update</property>
        Session session2 = factory.openSession();
        
        //get() - return null if object not found in chache as well as on database
        
        Employee employee_obj = (Employee)session2.get(Employee.class,1);
        //System.out.println("Employee Salary: "+employee_obj.getSalary());
        //System.out.println(employee_obj.getPerson()); //OnetoOne Mapping
        //System.out.println(employee_obj.getPerson().getFirstName());
        
        //Person person_obj = (Person)session2.get(Person.class,1);
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

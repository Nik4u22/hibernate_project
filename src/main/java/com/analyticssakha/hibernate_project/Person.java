package com.analyticssakha.hibernate_project;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 50, name = "first_name")
    private String firstName;

    @Column(length = 50, name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private char gender;
    
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE) //format date using temporal
    private  Date dateofbirth;
    
    @Column(name = "email")
    private String email;

    @Column(length = 3, name = "age")
    private int age;

    @Column(length = 10, name = "contact_no")
    private String contactno;

    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "pincode")
    private String pincode;
    
    @Lob
    @Column(name = "avtar", columnDefinition="longblob")
    private byte[] avtar;
    
    @Column(name = "date_added")
    @Temporal(TemporalType.DATE) //format date using temporal
    private  Date dateadded;
    
    @Transient //field will not reflect in table
    private int x;
    

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(int id, String firstName, String lastName, char gender, Date dateofbirth, String email, int age,
			String contactno, String address, String city, String state, String country, String pincode, byte[] avtar,
			Date dateadded, int x) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.age = age;
		this.contactno = contactno;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.avtar = avtar;
		this.dateadded = dateadded;
		this.x = x;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getContactno() {
		return contactno;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public byte[] getAvtar() {
		return avtar;
	}


	public void setAvtar(byte[] avtar) {
		this.avtar = avtar;
	}


	public Date getDateadded() {
		return dateadded;
	}


	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dateofbirth=" + dateofbirth + ", email=" + email + ", age=" + age + ", contactno=" + contactno
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + ", avtar=" + Arrays.toString(avtar) + ", dateadded=" + dateadded + ", x=" + x + "]";
	}
    
}

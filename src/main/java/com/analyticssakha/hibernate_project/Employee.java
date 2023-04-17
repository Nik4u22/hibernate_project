package com.analyticssakha.hibernate_project;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "salary")
    private int salary;
    
	private Education education;
	
	@OneToOne
	@JoinColumn(name = "person_Id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "company_Id")
	private Company company;

    public Employee() {

    }

	public Employee(int id, int salary, Education education, Person person, Company company) {
		super();
		this.id = id;
		this.salary = salary;
		this.education = education;
		this.person = person;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", education=" + education + ", person=" + person
				+ ", company=" + company + "]";
	}
    
}
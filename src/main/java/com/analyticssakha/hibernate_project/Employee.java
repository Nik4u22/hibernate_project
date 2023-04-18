package com.analyticssakha.hibernate_project;

import java.util.List;

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
	
	@ManyToMany
	@JoinTable(name = "employee_project",
	joinColumns = { @JoinColumn(name = "employee_Id") },
	inverseJoinColumns = { @JoinColumn(name = "project_Id")})
	private List<Project> projects;

    public Employee() {

    }

	public Employee(int id, int salary, Education education, Person person, Company company, List<Project> projects) {
		super();
		this.id = id;
		this.salary = salary;
		this.education = education;
		this.person = person;
		this.company = company;
		this.projects = projects;
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", education=" + education + ", person=" + person
				+ ", company=" + company + ", projects=" + projects + "]";
	}

    
}
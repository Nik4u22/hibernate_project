package com.analyticssakha.hibernate_project;

import jakarta.persistence.Embeddable;

@Embeddable
public class Education {
	private String degree_name;
	private String specialization;
	private String duration;
	private String passing_year;
	
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Education(String degree_name, String specialization, String duration, String passing_year) {
		super();
		this.degree_name = degree_name;
		this.specialization = specialization;
		this.duration = duration;
		this.passing_year = passing_year;
	}

	public String getDegree_name() {
		return degree_name;
	}

	public void setDegree_name(String degree_name) {
		this.degree_name = degree_name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPassing_year() {
		return passing_year;
	}

	public void setPassing_year(String passing_year) {
		this.passing_year = passing_year;
	}

	@Override
	public String toString() {
		return "Education [degree_name=" + degree_name + ", specialization=" + specialization + ", duration=" + duration
				+ ", passing_year=" + passing_year + "]";
	}

	
}

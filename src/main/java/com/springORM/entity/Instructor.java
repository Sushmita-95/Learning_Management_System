package com.springORM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="nameIs",query="from Instructor where instructor like :string")
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private int  instructor_id;
	
	@Column(name="instructor_name")
	private String instructor_name;
	
	@Column(name="instructor_training_exp")
	private String instructor_training_exp;
	
	@Column(name="instructor_email")
	private String instructor_email;

	public int getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}

	public String getInstructor_name() {
		return instructor_name;
	}

	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	public String getInstructor_training_exp() {
		return instructor_training_exp;
	}

	public void setInstructor_training_exp(String instructor_training_exp) {
		this.instructor_training_exp = instructor_training_exp;
	}

	public String getInstructor_email() {
		return instructor_email;
	}

	public void setInstructor_email(String instructor_email) {
		this.instructor_email = instructor_email;
	}

	@Override
	public String toString() {
		return "Instructor [instructor_id=" + instructor_id + ", instructor_name=" + instructor_name
				+ ", instructor_training_exp=" + instructor_training_exp + ", instructor_email=" + instructor_email
				+ "]";
	}
		
}

package com.hibernate.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student_info")
public class Student_Info {
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(strategy= GenerationType.AUTO, generator = "gen")
	private int rollno;

	@Column(name = "student_name")
	private String name;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

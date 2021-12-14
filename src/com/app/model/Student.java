package com.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@NamedQueries({ @NamedQuery(name = "getAllStudents", query = "from Student"),
		@NamedQuery(name = "getStudentsMC", query = "from Student where name_student like :name ") })
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_student;
	@Column
	private String name_student;
	@Column
	private String cin;
	@OneToMany(mappedBy = "student")
	private List<Lesson> lessons = new ArrayList<Lesson>();

	public Student() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id_student=" + id_student + ", name_student=" + name_student + ", cin=" + cin + "]";
	}

	public Student(Long id_student, String name_student, String cin) {
		super();
		this.id_student = id_student;
		this.name_student = name_student;
		this.cin = cin;
	}

	public Long getId_student() {
		return id_student;
	}

	public void setId_student(Long id_student) {
		this.id_student = id_student;
	}

	public String getName_student() {
		return name_student;
	}

	public void setName_student(String name_student) {
		this.name_student = name_student;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

}

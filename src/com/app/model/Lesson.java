package com.app.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "lesson")
@NamedQueries({ @NamedQuery(name = "getAllLessons", query = "from Vehicle"), })
public class Lesson implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_lesson;
	@Column
	private LocalDate lesson_date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_monitor")
	private Monitor monitor;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_student")
	private Student student;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vehicle")
	private Vehicle vehicle;

	public Lesson() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Lesson [id_lesson=" + id_lesson + ", lesson_date=" + lesson_date + ", monitor=" + monitor.toString()
				+ ", student=" + student.toString() + ", vehicle=" + vehicle.toString() + "]";
	}

	public Lesson(Long id_lesson, LocalDate lesson_date, Monitor monitor, Student student, Vehicle vehicle) {
		super();
		this.id_lesson = id_lesson;
		this.lesson_date = lesson_date;
		this.monitor = monitor;
		this.student = student;
		this.vehicle = vehicle;
	}

	public Long getId_lesson() {
		return id_lesson;
	}

	public void setId_lesson(Long id_lesson) {
		this.id_lesson = id_lesson;
	}

	public LocalDate getLesson_date() {
		return lesson_date;
	}

	public void setLesson_date(LocalDate lesson_date) {
		this.lesson_date = lesson_date;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}

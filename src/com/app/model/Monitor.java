package com.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "monitor")
@NamedQueries({ @NamedQuery(name = "getAllMonitors", query = "from Monitor"),
		@NamedQuery(name = "getMonitorsMC", query = "from Monitor where name_monitor like :name ") })
public class Monitor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_monitor;
	@Column
	private String name_monitor;
	@Column
	private String sexe;
	@Column
	private LocalDate birth;
	@OneToMany(mappedBy = "monitor")
	private List<Lesson> lessons = new ArrayList<Lesson>();

	public Monitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Monitor [id_monitor=" + id_monitor + ", name_monitor=" + name_monitor + ", sexe=" + sexe + ", birth="
				+ birth + "]";
	}

	public Monitor(Long id_monitor, String name_monitor, String sexe, LocalDate birth) {
		super();
		this.id_monitor = id_monitor;
		this.name_monitor = name_monitor;
		this.sexe = sexe;
		this.birth = birth;
	}

	public Long getId_monitor() {
		return id_monitor;
	}

	public void setId_monitor(Long id_monitor) {
		this.id_monitor = id_monitor;
	}

	public String getName_monitor() {
		return name_monitor;
	}

	public void setName_monitor(String name_monitor) {
		this.name_monitor = name_monitor;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

}

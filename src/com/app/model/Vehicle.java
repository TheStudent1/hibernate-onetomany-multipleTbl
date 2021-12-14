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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
@NamedQueries({ @NamedQuery(name = "getAllVehicles", query = "from Vehicle"),
		@NamedQuery(name = "getVehiclesMC", query = "from Vehicle where color like :name ") })
public class Vehicle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vehicle;
	@Column
	private int model;
	@Column
	private String color;
	@Column
	private LocalDate circulation_date;
	@OneToMany(mappedBy = "vehicle")
	private List<Lesson> lessons = new ArrayList<Lesson>();

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vehicle [id_vehicle=" + id_vehicle + ", model=" + model + ", color=" + color + ", circulation_date="
				+ circulation_date + "]";
	}

	public Vehicle(Long id_vehicle, int model, String color, LocalDate circulation_date) {
		super();
		this.id_vehicle = id_vehicle;
		this.model = model;
		this.color = color;
		this.circulation_date = circulation_date;
	}

	public Long getId_vehicle() {
		return id_vehicle;
	}

	public void setId_vehicle(Long id_vehicle) {
		this.id_vehicle = id_vehicle;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getCirculation_date() {
		return circulation_date;
	}

	public void setCirculation_date(LocalDate circulation_date) {
		this.circulation_date = circulation_date;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

}

package org.example.data.model;

import java.time.LocalDate;

public class Course {
	private int id;
	private String name;
	private String description;
	private int totalHour;
	private LocalDate startDate;
	private LocalDate endDate;

	public Course(String name, int id, String description, int totalHour, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.id = id;
		this.description = description;
		this.totalHour = totalHour;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(int totalHour) {
		this.totalHour = totalHour;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


}

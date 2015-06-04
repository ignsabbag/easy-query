package org.easyquery.model;

import java.io.Serializable;

/**
 * Model class for Conact
 */
public class Course implements Serializable {
	private Integer id;
	private String name;
	private Teacher teacher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}

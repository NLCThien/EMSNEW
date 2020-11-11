package com.example.demo.entities;
// Generated Oct 24, 2020, 7:32:02 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Majors generated by hbm2java
 */
@Entity
@Table(name = "Majors")
public class Majors{

	private String id;
	private String name;
	private String description;
	private String status;
	private Set<MajorsSemester> majorsSemesters = new HashSet<MajorsSemester>(0);
	private Set<Subject> subjects = new HashSet<Subject>(0);

	public Majors() {
	}

	public Majors(String id) {
		this.id = id;
	}

	public Majors(String id, String name, String description, String status,
			Set<MajorsSemester> majorsSemesters, Set<Subject> subjects) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.majorsSemesters = majorsSemesters;
		this.subjects = subjects;
	}

	@Id

	@Column(name = "ID")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "majors")
	public Set<MajorsSemester> getMajorsSemesters() {
		return this.majorsSemesters;
	}

	public void setMajorsSemesters(Set<MajorsSemester> majorsSemesters) {
		this.majorsSemesters = majorsSemesters;
	}

	@OneToMany(mappedBy = "majors")
	public Set<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

}

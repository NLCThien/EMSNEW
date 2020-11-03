package com.example.demo.entities;
// Generated Oct 24, 2020, 7:32:02 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Semester generated by hbm2java
 */
@Entity
@Table(name = "Semester")
public class Semester{

	private String id;
	private String name;
	private Date startTime;
	private Date endTime;
	private String status;
	private Set<Course> courses = new HashSet<Course>(0);
	private Set<MajorsSemester> majorsSemesters = new HashSet<MajorsSemester>(0);

	public Semester() {
	}

	public Semester(String id) {
		this.id = id;
	}

	public Semester(String id, String name, Date startTime, Date endTime, String status,
			Set<Course> courses, Set<MajorsSemester> majorsSemesters) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.courses = courses;
		this.majorsSemesters = majorsSemesters;
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "StartTime", length = 10)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EndTime", length = 10)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "Status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "semester")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@OneToMany(mappedBy = "semester")
	public Set<MajorsSemester> getMajorsSemesters() {
		return this.majorsSemesters;
	}

	public void setMajorsSemesters(Set<MajorsSemester> majorsSemesters) {
		this.majorsSemesters = majorsSemesters;
	}

}

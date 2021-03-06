package com.example.demo.entities;
// Generated Oct 24, 2020, 7:32:02 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Subject generated by hbm2java
 */
@Entity
@Table(name = "Subject")
public class Subject {

	private String id;
	private Majors majors;
	private String subjectname;
	private String description;
	private String status;
	private Set<MajorsSemester> majorsSemesters = new HashSet<MajorsSemester>(0);

	public Subject() {
	}


	public Subject(String id, Majors majors, String subjectname, String description,
			String status, Set<MajorsSemester> majorsSemesters) {
		this.id = id;
		this.majors = majors;
		this.subjectname = subjectname;
		this.description = description;
		this.status = status;
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

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "MajorID")
	public Majors getMajors() {
		return this.majors;
	}

	public void setMajors(Majors majors) {
		this.majors = majors;
	}

	@Column(name = "Subjectname")
	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
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

	@OneToMany(mappedBy = "subject")
	public Set<MajorsSemester> getMajorsSemesters() {
		return this.majorsSemesters;
	}

	public void setMajorsSemesters(Set<MajorsSemester> majorsSemesters) {
		this.majorsSemesters = majorsSemesters;
	}
	
	
}

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
 * ExamType generated by hbm2java
 */
@Entity
@Table(name = "Examtype")
public class ExamType {

	private String id;
	private String name;
	private String desc;
	private Set<Exam> exams = new HashSet<Exam>(0);

	public ExamType() {
	}

	public ExamType(String id) {
		this.id = id;
	}

	public ExamType(String id, String name, String desc, Set<Exam> exams) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.exams = exams;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
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

	@Column(name = "desc")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@OneToMany(mappedBy = "examType")
	public Set<Exam> getExams() {
		return this.exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

}

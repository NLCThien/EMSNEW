package com.example.demo.entities;
// Generated Oct 24, 2020, 7:32:02 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ExamResult generated by hbm2java
 */
@Entity
@Table(name = "ExamResult")
public class ExamResult {
	private int id;
	private Exam exam;
	private Student student;
	private Float mark;
	
	
	public ExamResult() {
		super();
	}


	public ExamResult(int id, Exam exam, Student student, Float mark) {
		super();
		this.id = id;
		this.exam = exam;
		this.student = student;
		this.mark = mark;
	}

	@Id
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ExamID")
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "StudentID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	@Column(name = "Mark")
	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}
	
	
	

}

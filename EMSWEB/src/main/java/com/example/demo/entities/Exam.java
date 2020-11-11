package com.example.demo.entities;
// Generated Oct 24, 2020, 7:32:02 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Exam generated by hbm2java
 */
@Entity
@Table(name = "Exam")
public class Exam{

	private String id;
	private Course course;
	private ExamType examType;
	private String name;
	private Date startDate;
	private Date endDate;
	private Set<ExamResult> examResults = new HashSet<ExamResult>(0);

	public Exam() {
	}

	public Exam(String id) {
		this.id = id;
	}

	public Exam(String id, Course course, ExamType examType, String name, Date startDate, Date endDate,
			Set<ExamResult> examResults) {
		this.id = id;
		this.course = course;
		this.examType = examType;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.examResults = examResults;
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CourseID")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Examtypeid")
	public ExamType getExamType() {
		return this.examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Startdate", length = 23)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enddate", length = 23)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@OneToMany(mappedBy = "exam")
	public Set<ExamResult> getExamResults() {
		return this.examResults;
	}

	public void setExamResults(Set<ExamResult> examResults) {
		this.examResults = examResults;
	}

}

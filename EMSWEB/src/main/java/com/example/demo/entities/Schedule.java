package com.example.demo.entities;
// Generated Oct 24, 2020, 7:32:02 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Schedule generated by hbm2java
 */
@Entity
@Table(name = "schedule")
public class Schedule {

	private String id;
	private Amphitheater amphitheater;
	private Classroom classroom;
	private SchoolRoom schoolroom;
	private StudyShift studyShift;
	private String date;
	private Course course;
	
	
	public Schedule() {
		super();
	}


	public Schedule(String id, Amphitheater amphitheater, Classroom classroom, SchoolRoom schoolroom,
			StudyShift studyShift, String date,Course course) {
		super();
		this.id = id;
		this.amphitheater = amphitheater;
		this.classroom = classroom;
		this.schoolroom = schoolroom;
		this.studyShift = studyShift;
		this.date = date;
		this.course=course;
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
	@JoinColumn(name = "AmphitheaterID")
	public Amphitheater getAmphitheater() {
		return this.amphitheater;
	}

	public void setAmphitheater(Amphitheater amphitheater) {
		this.amphitheater = amphitheater;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ClassroomID")
	public Classroom getClassroom() {
		return this.classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Roomid")
	public SchoolRoom getschoolroom() {
		return this.schoolroom;
	}

	public void setschoolroom(SchoolRoom schoolroom) {
		this.schoolroom = schoolroom;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Studyshiftid")
	public StudyShift getStudyShift() {
		return this.studyShift;
	}

	public void setStudyShift(StudyShift studyShift) {
		this.studyShift = studyShift;
	}

	@Column(name = "Date", length = 10)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "courseid")
	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}

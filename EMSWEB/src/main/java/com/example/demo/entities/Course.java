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
 * Course generated by hbm2java
 */
@Entity
@Table(name = "course")
public class Course {

	private String id;
	private Semester semester;
	private Teacher teacher;
	private String name;
	private String desc;
	private String section;
	private String status;
//	private String classroomId;
	private Set<Attandence> attandences = new HashSet<Attandence>(0);
	private Set<Exam> exams = new HashSet<Exam>(0);
	private Set<ClassroomStudent> classroomStudents = new HashSet<ClassroomStudent>(0);
	private Set<Schedule> schedule = new HashSet<Schedule>(0);
	
	public Course() {
	}

	public Course(String id, String name) {
		this.id = id;
		this.name = name;
	}
//	String classroomId,
	public Course(String id, Semester semester, Teacher teacher, String name, String desc,
			String section, String status,  Set<Attandence> attandences,
			Set<Exam> exams, Set<ClassroomStudent> classroomStudents,Set<Schedule> schedule) {
		this.id = id;
		this.semester = semester;
		this.teacher = teacher;
		this.name = name;
		this.desc = desc;
		this.section = section;
		this.status = status;
//		this.classroomId = classroomId;
		this.attandences = attandences;
		this.exams = exams;
		this.classroomStudents = classroomStudents;
		this.schedule=schedule;
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
	@JoinColumn(name = "SemeterID")
	public Semester getSemester() {
		return this.semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TeacherID")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "[Desc]")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "Section")
	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Column(name = "Status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	@Column(name = "ClassroomID")
//	public String getClassroomId() {
//		return this.classroomId;
//	}
//
//	public void setClassroomId(String classroomId) {
//		this.classroomId = classroomId;
//	}

	@OneToMany(mappedBy = "course")
	public Set<Attandence> getAttandences() {
		return this.attandences;
	}

	public void setAttandences(Set<Attandence> attandences) {
		this.attandences = attandences;
	}

	@OneToMany(mappedBy = "course")
	public Set<Exam> getExams() {
		return this.exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	@OneToMany(mappedBy = "course")
	public Set<ClassroomStudent> getClassroomStudents() {
		return this.classroomStudents;
	}

	public void setClassroomStudents(Set<ClassroomStudent> classroomStudents) {
		this.classroomStudents = classroomStudents;
	}
	
	@OneToMany(mappedBy = "course")
	public Set<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
	}

	
}

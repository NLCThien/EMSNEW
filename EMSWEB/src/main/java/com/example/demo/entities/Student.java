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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "Student")
public class Student  {

	private String id;
	private Parent parent;
	private String fname;
	private String lname;
	private String image;
	private String email;
	private String dob;
	private String phone;
	private String address;
	private String status;
	private Integer idcard;
	private String classroomId;
	private Set<ClassroomStudent> classroomStudents = new HashSet<ClassroomStudent>(0);
	private Set<ExamResult> examResults = new HashSet<ExamResult>(0);
	private Set<Attandence> attandences = new HashSet<Attandence>(0);

	public Student() {
	}

	public Student(String id, String fname, String lname, String dob) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
	}
	
	public Student(String id, Parent parent, String fname, String lname, String image,
			String email, String dob, String phone, String address, String status, Integer idcard,
			String classroomId,Set<ClassroomStudent> classroomStudents, Set<ExamResult> examResults,Set<Attandence> attandences) {
		this.id = id;
		this.parent = parent;
		this.fname = fname;
		this.lname = lname;
		this.image = image;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.idcard = idcard;
		this.classroomId = classroomId;
		this.classroomStudents = classroomStudents;
		this.examResults = examResults;
		this.attandences = attandences;
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
	@JoinColumn(name = "ParentID")
	public Parent getParent() {
		return this.parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Column(name = "Fname", nullable = false)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "Lname", nullable = false)
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name = "Image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "Phone", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "Idcard")
	public Integer getIdcard() {
		return this.idcard;
	}

	public void setIdcard(Integer idcard) {
		this.idcard = idcard;
	}

	@Column(name = "ClassroomID")
	public String getClassroomId() {
		return this.classroomId;
	}

	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}

	@OneToMany(mappedBy = "student")
	public Set<ClassroomStudent> getClassroomStudents() {
		return this.classroomStudents;
	}

	public void setClassroomStudents(Set<ClassroomStudent> classroomStudents) {
		this.classroomStudents = classroomStudents;
	}

	@OneToMany(mappedBy = "student")
	public Set<ExamResult> getExamResults() {
		return this.examResults;
	}

	public void setExamResults(Set<ExamResult> examResults) {
		this.examResults = examResults;
	}

	@OneToMany(mappedBy = "student")
	public Set<Attandence> getAttandences() {
		return this.attandences;
	}

	public void setAttandences(Set<Attandence> attandences) {
		this.attandences = attandences;
	}

}

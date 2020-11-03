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
 * Parent generated by hbm2java
 */
@Entity
@Table(name = "Parent")
public class Parent {

	private String id;
	private String fname;
	private String lname;
	private String image;
	private String email;
	private Date dob;
	private String phone;
	private String address;
	private String status;
	private String relationship;
	private Set<Student> students = new HashSet<Student>(0);

	public Parent() {
	}

	public Parent(String id, String fname, String lname, Date dob) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
	}

	public Parent(String id, String fname, String lname, String image, String email, Date dob,
			String phone, String address, String status, String relationship, Set<Student> students) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.image = image;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.relationship = relationship;
		this.students = students;
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "Dob", nullable = false, length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
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

	@Column(name = "Relationship")
	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@OneToMany(mappedBy = "parent")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}

package com.my.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {
	@Id
	// id自动生成
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "clas")
	private String clas;

	@Column(name = "interest")
	private String interest;

	public Student() {

	}

	public Student(Long id, String name, String clas, String interest) {
		super();
		this.id = id;
		this.name = name;
		this.clas = clas;
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clas=" + clas + ", interest=" + interest + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

}

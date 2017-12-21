package com.my.model;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name = "people")
public class People  implements Serializable {

	@EmbeddedId
	private PeopleKey id;

	@Column(name = "age")
	private int age;
	
	@Column(name = "address")
	private String address;

	public PeopleKey getId() {
		return id;
	}

	public void setId(PeopleKey id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}

	public People() {
		super();
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", age=" + age + ", address=" + address
				+ "]";
	}

	
}

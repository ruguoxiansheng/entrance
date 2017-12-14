package com.my.model;

import javax.persistence.*;
@Entity
@Table(name = "people")
//@IdClass(PeopleKey.class)
public class People extends PeopleKey{
	
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

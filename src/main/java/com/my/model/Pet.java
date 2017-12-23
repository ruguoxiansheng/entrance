package com.my.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet  implements Serializable{
	@Id
	// id自动生成
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "pet_name")
	private String petName;
	@Column(name = "pet_class")
	private String petClass;

	public String getPetClass() {
		return petClass;
	}

	public void setPetClass(String petClass) {
		this.petClass = petClass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", petName=" + petName + ", petClass="
				+ petClass + "]";
	}

}

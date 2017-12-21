package com.my.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
@Embeddable
public class PeopleKey implements Serializable  {
	
	@Column(name = "name")
	private String name;
	@Column(name = "idcardno")
	private String idcardno;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcardno() {
		return idcardno;
	}
	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno;
	}

	@Override
	public String toString() {
		return "PeopleKey [name=" + name + ", idcardno=" + idcardno + "]";
	}

}

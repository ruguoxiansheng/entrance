package com.my.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idcardno == null) ? 0 : idcardno.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeopleKey other = (PeopleKey) obj;
		if (idcardno == null) {
			if (other.idcardno != null)
				return false;
		} else if (!idcardno.equals(other.idcardno))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PeopleKey [name=" + name + ", idcardno=" + idcardno + "]";
	}
	

}

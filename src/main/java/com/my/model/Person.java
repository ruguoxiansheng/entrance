package com.my.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "person")
public class Person  implements Serializable{
	@Id
	// id自动生成
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	
	//cascade:表的级联操作
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL) //JPA注释： 一对一 关系
	
	//referencedColumnName：参考列名,默认的情况下是列表的主键
	//nullable=是否可以为空，
	//insertable：是否可以插入，
	//updatable：是否可以更新
	// columnDefinition=列定义，
	//foreignKey=外键
    @JoinColumn(name="pet_id",referencedColumnName="id",nullable=false)
	private Pet pet;

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

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", pet=" + pet + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

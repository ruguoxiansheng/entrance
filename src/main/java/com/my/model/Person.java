package com.my.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "person")
public class Person {
	@Id
	// id自动生成
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	
	@OneToOne(mappedBy="person") //JPA注释： 一对一 关系
	// name="数据库表中person对应的列名"，table：这个类映射的表名，referencedColumnName：参考列名
	// unique=,nullable=是否可以为空，insertable：是否可以插入，updatable：是否可以更新
	// columnDefinition=列定义，foreignKey=外键
    @JoinColumn(table="pet",name="pet_id"/*,foreignKey={name="pet_name"}*/)
	//http://blog.csdn.net/langjian2012/article/details/38853045
//	 @Cascade( { org.hibernate.annotations.CascadeType.ALL } )    
//	@ForeignKey(name="pet_name")
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
	
}

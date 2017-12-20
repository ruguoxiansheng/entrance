package com.my.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.my.dao.PersonJPA;
import com.my.dao.PetJPA;
import com.my.model.Person;
import com.my.model.Pet;

@Service
public class TableRelationService {
	
	@Resource
	private PersonJPA personJPA;
	
	@Resource
	private PetJPA petJPA;

	public Long save(JSONObject record) {
		
		// 组装person
		Person person = new Person();
		person.setName(record.getString("personName"));
		
		Pet pet = new Pet();
		pet.setPetName("petName");
		pet.setPetClass("petClass");
		
		person.setPet(pet);
		
		petJPA.save(pet);
		personJPA.save(person);
		
		return 4l;
	}

}

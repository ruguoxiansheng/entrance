package com.my.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
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
		pet.setPetName(record.getString("petName"));
		pet.setPetClass(record.getString("petClass"));
		
		person.setPet(pet);
		
//		petJPA.save(pet);
		personJPA.save(person);
		
		return 4l;
	}

	public JSONObject getPet(JSONObject record) {
		
		Person person = personJPA.findOne(record.getLongValue("id"));
		Pet pet = person.getPet();
		System.out.println(person.toString());
		return (JSONObject) JSON.toJSON(person);
	}

	public Long delete(JSONObject record) {
		personJPA.delete(record.getLongValue("id"));
		return 4l;
	}

	public Long update(JSONObject record) {
		
		Person person = new Person();
		person.setId(record.getLong("id"));
		person.setName(record.getString("personName"));
		
		Pet pet = new Pet();
		pet.setPetName(record.getString("petName"));
		pet.setPetClass(record.getString("petClass"));
		
		person.setPet(pet);
		
//		petJPA.save(pet);
		personJPA.save(person);
		return 4l;
	}

}

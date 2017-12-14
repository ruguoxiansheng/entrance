package com.my.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.dao.PeopleRepository;
import com.my.model.People;
import com.my.model.PeopleKey;

@Service
public class PeopleService {
	
	@Resource
	private PeopleRepository peopleRepository;

	public People findOne() {
		PeopleKey peopleKey = new PeopleKey();
		peopleKey.setName("张三");
		peopleKey.setIdcardno("340123");
		People people = peopleRepository.findOne(peopleKey);
		return people;
	}

}

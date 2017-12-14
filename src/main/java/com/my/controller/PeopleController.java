package com.my.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.People;
import com.my.service.PeopleService;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {
	@Resource
	private PeopleService peopleService;
	
	 @RequestMapping(value = "/find")
	    public void find() throws Exception
	    {
	         People people = peopleService.findOne();
	         System.out.println(people.toString());
	    }
}

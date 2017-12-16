package com.my.controller;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.People;
import com.my.model.PeopleKey;
import com.my.service.PeopleService;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {
	@Resource
	private PeopleService peopleService;
	
//	@Autowired
//    @PersistenceContext
//    private EntityManager entityManager;

	
	 @RequestMapping(value = "/findOne")
	    public void find() throws Exception
	    {
	         People people = peopleService.findOne();
	         System.out.println(people.toString());
	    }
	 
	
	 
//	 @RequestMapping(value = "/useEntityManager")
//	 public void findUseEntityManager() throws Exception
//	    {
//		 	PeopleKey peopleKey = new PeopleKey();
//			peopleKey.setName("张三");
//			peopleKey.setIdcardno("340123");
//	         People people = entityManager.find(People.class,peopleKey);
//	         System.out.println(people.toString());
//	    }
}

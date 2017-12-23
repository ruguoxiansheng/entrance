package com.my.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.classmate.AnnotationConfiguration;
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
	
  private SessionFactory sessionFactory;

  @Autowired
  public void SomeService(EntityManagerFactory factory) {
    if(factory.unwrap(SessionFactory.class) == null){
      throw new NullPointerException("factory is not a hibernate factory");
    }
    this.sessionFactory = factory.unwrap(SessionFactory.class);
  }
	
	 
	public Long save(JSONObject record) {
		
		// 组装person
		Person person = new Person();
		person.setName(record.getString("personName"));
		JSONObject petObj = record.getJSONObject("pet");
		if (null != petObj) {
			Pet pet = new Pet();
			pet.setPetName(petObj.getString("petName"));
			pet.setPetClass(petObj.getString("petClass"));
			
			person.setPet(pet);
		}
		personJPA.save(person);
		
		return 4l;
	}

	public JSONObject getPet(JSONObject record) {
		
		Person person = personJPA.findOne(record.getLongValue("id"));
		System.out.println(person.toString());
		return (JSONObject) JSON.toJSON(person);
	}

	public Long delete(JSONObject record) {
		personJPA.delete(record.getLongValue("id"));
		return 4l;
	}

	public Long update(JSONObject record) {
		
//		 Session session = sessionFactory.getCurrentSession();
		 Session	 session = sessionFactory.openSession();
         session.beginTransaction();
         
         Person personRecord = session.get(Person.class, record.getLongValue("id"));
         
        personRecord.setName(record.getString("personName"));
        
        JSONObject petObject = record.getJSONObject("pet");
		
        if (petObject != null) {
        	 // 如果这里的pet为空
        	 Pet petRecord = null;
	        if (personRecord.getPet() != null) {
	        	petRecord = session.get(Pet.class, personRecord.getPet().getId());
	        }
         
          petRecord.setPetName(petObject.getString("petName"));
          petRecord.setPetClass(petObject.getString("petClass"));
          
        }
		personJPA.save(personRecord);
		return 4l;
	}

}

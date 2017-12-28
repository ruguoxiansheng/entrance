package com.my.service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.dao.HusbandJPA;
import com.my.dao.PersonJPA;
import com.my.dao.PetJPA;
import com.my.dao.WifeJPA;
import com.my.model.Husband;
import com.my.model.Person;
import com.my.model.Pet;
import com.my.model.Wife;

@Service
public class TableRelationService {
	
	@Resource
	private PersonJPA personJPA;
	
	@Resource
	private PetJPA petJPA;
	
	@Resource
	private HusbandJPA husbandJPA;
	
	@Resource
	private WifeJPA wifeJPA;
	
	@Resource
	private EntityManager em;
	
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
	  @Transactional
	public Long update(JSONObject record) {
		
		 Session session = sessionFactory.getCurrentSession();
//		 Session	 session = sessionFactory.openSession();
         session.beginTransaction();
         
         Person personRecord = session.get(Person.class, record.getLongValue("id"));
         
        personRecord.setName(record.getString("personName"));
        
        JSONObject petObject = record.getJSONObject("pet");
        
       
		
        if (petObject != null) {
        	 // 如果这里的pet为空
        	Pet petRecord = new Pet();
	        if (personRecord.getPet() != null) {
	        	petRecord   = session.get(Pet.class, personRecord.getPet().getId());

	        }
          petRecord.setPetName(petObject.getString("petName"));
          petRecord.setPetClass(petObject.getString("petClass"));
          
          personRecord.setPet(petRecord);
          
        }
        personJPA.save(personRecord);
		return 4l;
	}

// 一对一 双向，husband是关系的维护端，wife是关系的被维护端
	  // 保存
	public Object twoSave(JSONObject record) {
		
		JSONObject husbandObj = record.getJSONObject("husband");
		Husband husband = JSON.toJavaObject(husbandObj, Husband.class);
		
		JSONObject wifeObj = record.getJSONObject("wife");
		Wife wife = JSON.toJavaObject(wifeObj, Wife.class);
		
		husband.setWife(wife);
		
		Husband hsbandReturn = husbandJPA.save(husband);
		// 创建的时候只能通过关系的维护端来建立关系。
//		wife.setHusband(husband);
//		wifeJPA.save(wife);
		return JSON.toJSON(hsbandReturn);
	}

	// 查询
	public JSONObject twoGet(JSONObject record) {
		Husband husband = husbandJPA.findOne(record.getLongValue("id"));
		System.out.println(husband.toString());
//		JSONString hus = JSON.toJSONString(husband.toString());
		return JSON.parseObject(husband.toString());
		
//		return (JSONObject) JSON.toJSON(husband);
	}

	// 删除
	public Long twoDelete(JSONObject record) {
		husbandJPA.delete(record.getLongValue("id"));
		return 4l;
	}

	 @Transactional
	public Long twoUpdate(JSONObject record) {
		Session session = sessionFactory.getCurrentSession();
//		 Session	 session = sessionFactory.openSession();
        session.beginTransaction();
        
        Husband husbandRecord = session.get(Husband.class, record.getLongValue("id"));
        
       
       JSONObject wifeObj = record.getJSONObject("wife");
       
       Wife wife = JSON.toJavaObject(wifeObj, Wife.class);
       
       husbandRecord.setWife(wife);
       
       husbandJPA.save(husbandRecord);
       
		return 4l;
	}

}

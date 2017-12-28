package com.my;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.my.model.Husband;
import com.my.model.Person;
import com.my.model.Pet;
import com.my.model.Wife;

public class Test {

	public static void main(String[] args) {
//		String a = "{'hid':3, 'hname':张三, 'hidCard':340123199011014456, 'wife':{'wid':1, 'wname':王青, 'widCard':'34012319901101445x'}}";
//		Person p = new Person();
//		p.setId(2l);
//		p.setName("zhang");
//		Pet pet = new Pet();
//		pet.setId(3l);
//		pet.setPetClass("dog");
//		pet.setPetName("wang");
//		JSONObject bob = (JSONObject) JSON.toJSON(p);
//		System.out.println(JSON.toJSONString(bob));
		
		Husband h = new Husband();
		h.setHid(1l);
		h.setHname("掌声呢");
		h.setHidCard("23444");
		Wife w = new Wife();
		w.setWid(4l);
		w.setWidCard("2344");
		w.setWname("shzn");
		h.setWife(w);
		JSON.parseObject(h.toString());
	}

}

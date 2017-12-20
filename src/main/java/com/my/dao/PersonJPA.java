package com.my.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.model.Person;


public interface PersonJPA extends JpaRepository<Person,Long>{

}

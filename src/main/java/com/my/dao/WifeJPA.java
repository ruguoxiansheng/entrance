package com.my.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.model.Person;
import com.my.model.Wife;


public interface WifeJPA extends JpaRepository<Wife,Long>{

}

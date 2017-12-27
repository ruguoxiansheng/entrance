package com.my.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.model.Husband;
import com.my.model.Person;


public interface HusbandJPA extends JpaRepository<Husband,Long>{

}

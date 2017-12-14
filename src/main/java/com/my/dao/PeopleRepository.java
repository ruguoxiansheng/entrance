package com.my.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.model.People;
import com.my.model.PeopleKey;


public interface PeopleRepository extends JpaRepository<People,PeopleKey> {

}

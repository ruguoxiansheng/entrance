package com.my.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.model.Pet;


public interface PetJPA extends JpaRepository<Pet,Long> {

}

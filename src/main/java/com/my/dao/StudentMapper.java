package com.my.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.model.Student;

//@Mapper
public interface StudentMapper extends JpaRepository<Student, Long> {
	// int queryCount();
	//
	@Query(value = "select * from student where id < ?1", nativeQuery = true)
	public List<Student> findAll(Long id);
}

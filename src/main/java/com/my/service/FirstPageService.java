package com.my.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.my.dao.StudentMapper;
import com.my.model.Student;
import com.my.model.User;

@Service
// @ConfigurationProperties(value = "classpath*:application.properties")
public class FirstPageService {
	@Value("${name}")
	private String name;

	@Resource
	private User user;

	@Value("${my.number}")
	private int age;

	@Resource
	private StudentMapper studentMapper;

	public String getString() {

		// return name;
		// int a = studentMapper.queryCount();
		// return a + "";
		return "Hellow World!";
	}

	public String addStudent(Student stu) {
		studentMapper.save(stu);
		return "添加成功";
	}

	public String deleteStudent(Long id) {
		studentMapper.delete(id);
		return "删除成功";
	}

	public String updateStudent(Student stu) {
		// 如果有就更新，没有就添加
		studentMapper.save(stu);
		return "更新成功";
	}

	public List<Student> listStudent() {

		return studentMapper.findAll();
	}

	public List<Student> nativeQuery(Long id) {
		return studentMapper.findAll(id);
	}
}

package com.my.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	public List<Student> pageRequest() {
		PageRequest pageRequest = new PageRequest(1, 3);
		Page<Student> stuPage = studentMapper.findAll(pageRequest);
		List<Student> stuList = stuPage.getContent();
		return stuList;
	}

	public List<Student> pageAndSortRequest() {
		Sort sort1 = new Sort(Sort.Direction.DESC, "id");
		Sort sort2 = new Sort(Sort.Direction.ASC, "name");
		// 把两个排序的条件取取与
		Sort sort = sort1.and(sort2);
		PageRequest pageRequest = new PageRequest(1, 2, sort);
		Page<Student> stuPage = studentMapper.findAll(pageRequest);
		List<Student> stuList = stuPage.getContent();
		return stuList;
	}
}

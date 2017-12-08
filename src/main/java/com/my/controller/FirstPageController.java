package com.my.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.annotation.Fooish;
import com.my.model.Student;
import com.my.service.FirstPageService;
import com.my.service.QRCodeUtil;

@RestController
@Fooish(tags = { "this_is_class" })
public class FirstPageController {

	@Value(value = "${erweima.location:D:/Workspaces/MyEclipse 2015/entrance/src/main/resources/erweima.png}")
	private String imgPath;

	@Resource
	private FirstPageService firstPageService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Fooish(tags = { "this_is_method" })
	String home() {
		return firstPageService.getString();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String addStudent(Student student) {
		return firstPageService.addStudent(student);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	String deleteStudent(Long id) {
		return firstPageService.deleteStudent(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	String updateStudent(Student student) {
		return firstPageService.updateStudent(student);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	List<Student> listStudent() {
		return firstPageService.listStudent();
	}

	// 采用的是自定义的方法
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	List<Student> list2Student(Long id) {
		return firstPageService.nativeQuery(id);
	}

	// 分页查询
	@RequestMapping(value = "/pageRequest", method = RequestMethod.GET)
	List<Student> pageRequest() {

		return firstPageService.pageRequest();
	}

	// 分页与排序查询
	@RequestMapping(value = "/pageAndSortRequest", method = RequestMethod.GET)
	List<Student> pageAndSortRequest() {

		return firstPageService.pageAndSortRequest();
	}

	@RequestMapping(value = "/erweima", method = RequestMethod.GET)
	public void qrcode(String content, @RequestParam(defaultValue = "300", required = false) int width,
			@RequestParam(defaultValue = "300", required = false) int height, HttpServletResponse response) {
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			QRCodeUtil.writeToStream(content, outputStream, width, height);
			File dir = new File(imgPath);
			if (!dir.isDirectory() || !dir.exists()) {
				dir.createNewFile();
			}
			QRCodeUtil.createQRCode(content, imgPath, width, height);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

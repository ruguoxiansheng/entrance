package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {
	 @RequestMapping("/login")
	    public String userList2(Model model) throws Exception {
//	        model.addAttribute("hello","Hello, Spring Boot!");
//	        model.addAttribute("userList", userService.userList());
	        return "/login";
	    }
}

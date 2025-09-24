package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@GetMapping({ "/home", "/index" })
	public String getHome() {
		System.out.println("\nGoing Towards Home...");
		return "index";
	}

	@GetMapping({ "/register" })
	public String doRegistrationGet(HttpServletRequest request) {
		System.out.println("\nGetting Data... (Get)");
		System.out.println("Name: " + request.getParameter("name"));
		System.out.println("age: " + request.getParameter("age"));
		System.out.println("City: " + request.getParameter("city"));
		System.out.println("Salary: " + request.getParameter("salary"));
		return "redirect:/index";
	}

	@PostMapping({ "/register" })
	public String doRegistrationPost(HttpServletRequest request) {
		System.out.println("\nGetting Data... (Post)");
		System.out.println("Name: " + request.getParameter("name"));
		System.out.println("age: " + request.getParameter("age"));
		System.out.println("City: " + request.getParameter("city"));
		System.out.println("Salary: " + request.getParameter("salary"));
		return "redirect:/index";
	}
}

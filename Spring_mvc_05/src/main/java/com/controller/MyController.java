package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

	@GetMapping({ "/home", "/index" })
	public String getHome() {
		System.out.println("\nGoing Towards Home...");
		return "index";
	}

	// for the incomplete data
	// Query Parameters(https://example.com/search?name=abc&salary=45000&...)
	@GetMapping({ "/register" })
	public String doRegistrationGet(@RequestParam("name") String name, @RequestParam("salary") int salary) {
		System.out.println("\nGetting Data... (Get)");
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		return "redirect:/index";
	}
}

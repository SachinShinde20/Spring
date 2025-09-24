package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@GetMapping({ "/home", "/index", "/" })
	public String getHome() {
		System.out.println("\nGoing Towards Home...");
		return "index";
	}

	@GetMapping({ "/register" })
	public String doRegistrationGet(@ModelAttribute Employee employee) {
		System.out.println("\nGetting Data... (Get)");
		System.out.println(employee);
		return "redirect:/index";
	}

	@PostMapping({ "/register" })
	public String doRegistrationPost(@ModelAttribute Employee employee) {
		System.out.println("\nGetting Data... (Post)");
		System.out.println(employee);
		return "redirect:/index";
	}
}

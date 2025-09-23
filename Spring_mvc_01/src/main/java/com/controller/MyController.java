package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping({ "/home", "/index" })
	public String getHome() {
		System.out.println("Opening Home/index page...");
		return "index";
	}

	@GetMapping("/contact")
	public String getToContact() {
		System.out.println("Opening Contact Page ...");
		return "contact";
	}
}

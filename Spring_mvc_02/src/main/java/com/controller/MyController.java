package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping({ "/home", "/index" })
	public String getHome() {
		System.out.println("\nGoing Towards Home...");
		return "index";
	}
}

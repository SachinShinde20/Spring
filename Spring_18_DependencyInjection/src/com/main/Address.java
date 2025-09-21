package com.main;

import org.springframework.stereotype.Component;

@Component
public class Address {
	String city = "Kolhapur";
	int pincode = 416000;
	
	@Override
	public String toString() {
		return "Address [city=" + city + ", pincode=" + pincode + "]";
	}
}

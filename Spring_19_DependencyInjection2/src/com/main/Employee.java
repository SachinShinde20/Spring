package com.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class Employee {

	@Value("101")
	private int id;

	@Value("Sachin")
	private String name;

	// if key is present : if key is not present
	@Value("${My.String:No such Key found in the .properties file}") // From Properties File
	private String str;

	/*
	 * // SPEL
	 */
	@Value("#{environment['My.String']}") // From Properties using SPEL
	private String str2;

	@Value("#{test.returnString()}") // From Method Of Test Class (test is an default bean name) (bean name.method)
	private String msg;

	@Value("#{T(java.lang.Math).random * 100}") // From Static Method of MathClass
	private float marks;

	@Value("#{10 > 20?'Result is True':'Result is False'}") // result private
	private String result;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", str=" + str + ", str2=" + str2 + ", msg=" + msg + ", marks="
				+ marks + ", result=" + result + "]";
	}
}

package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.model.Address;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Address address) {
		System.out.println(address);
		return "{'module':'addressspringmvc'}";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(String name, int age, String addr) {
		System.out.println("address update ..." + name + ", age==>" + age + ", addr==>" + addr);
		return "{'module':'addressupdate'}";
	}
}

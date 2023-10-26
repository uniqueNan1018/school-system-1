package com.school.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.model.Address;
import com.school.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "/users", method=RequestMethod.POST)
	@ResponseBody
	public String save(User user) {
		System.out.println(user);
		return "{'module':'springmvc'}";
	}
	
	@RequestMapping(value = "/users/{userId}", method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable int userId) {
		System.out.println(userId);
		return "{'module':'springmvc'}";
	}
	
	@RequestMapping(value = "/users", method=RequestMethod.PUT)
	@ResponseBody
	public String update(User user) {
		System.out.println(user);
		return "{'module':'springmvc'}";
	}
	
	@RequestMapping("/likes")
	@ResponseBody
	public String likes(String[] likes) {
		System.out.println(Arrays.deepToString(likes));
		return "{'module':'springmvc'}";
	}
	
	@RequestMapping("/listLikes")
	@ResponseBody
	public String listLikes(@RequestParam List<String> likes) {
		System.out.println(likes);
		return "{'module':'springmvc'}";
	}
	
	@RequestMapping("/listParamForJson")
	@ResponseBody
	public String listParamForJson(@RequestBody List<String> likes) {
		System.out.println(likes);
		return "{'module':'springmvc for json params'}";
	}
	
	@RequestMapping("/pojoParamForJson")
	@ResponseBody
	public String pojoParamForJson(@RequestBody User user) {
		System.out.println(user);
		return "{'module':'springmvc for json params'}";
	}
	
	@RequestMapping("/listPojoParamForJson")
	@ResponseBody
	public String listPojoParamForJson(@RequestBody List<User> list) {
		System.out.println(list);
		return "{'module':'springmvc for json params'}";
	}
	
	@RequestMapping("/dateParam")
	@ResponseBody
	public String dateParam(@DateTimeFormat(pattern="yyyy-MM-dd") Date date1) {
//		System.out.println(date);
		System.out.println(date1);
		return "{'module':'springmvc for date'}";
	}
	
	@RequestMapping("/jumpPage")
	public String jumpPage() {
		System.out.println("jumpPage");
		return "/page.jsp";
	}
	
	@RequestMapping("/toText")
	@ResponseBody
	public String toText() {
		System.out.println("toText");
		return "response text";
	}
	
	@RequestMapping("/toJsonPOJO")
	@ResponseBody
	public User toJsonPOJO() {
		System.out.println("toJsonPOJO");
		User user = new User();
		user.setName("りな");
		Address address = new Address();
		address.setAddress("東京都練馬区");
		address.setPostCode("1770053");
		user.setAddress(address);
		return user;
	}
	
	
}

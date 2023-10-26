package com.school.controller;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Book;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/book")
public class BookController {
	
//	@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public String save(Book book) {	
		System.out.println(book);
		return "{}";
	}
	
//	@RequestMapping(method=RequestMethod.PUT)
	@PutMapping
	public String update(Book book) {	
		System.out.println(book);
		return "{}";
	}
	
//	@RequestMapping(value="/${bookId}", method=RequestMethod.DELETE)
	@DeleteMapping("${bookId}")
	public String delete(@PathVariable Integer bookId) {	
		System.out.println(bookId);
		return "{}";
	}
}

package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.NewBook;
import com.school.service.NewBookService;

@RestController
@RequestMapping("/newBooks")
public class NewBookController {
//	@PostMapping
//	public String save(@RequestBody NewBook newBook) {
//		System.out.println("newbook => " + newBook);
//		return "{'module':'newbook save success'}";
//	}
//	
//	@GetMapping
//	public List<NewBook> getAll() {
//		List<NewBook> list = new ArrayList<>();
//		
//		NewBook newBook1 = new NewBook();
//		newBook1.setId(0);
//		newBook1.setType("ミステリー");
//		newBook1.setName("希望の糸");
//		newBook1.setDescription("東野圭吾の新作");
//		list.add(newBook1);
//		
//		NewBook newBook2 = new NewBook();
//		newBook2.setId(1);
//		newBook2.setType("小説");
//		newBook2.setName("クスノキの番人");
//		newBook2.setDescription("感動エンターテイメント作品");
//		list.add(newBook2);
//		return list;
//	}
	
	@Autowired
	private NewBookService newBookService;
	
	@PostMapping
	public Result save(@RequestBody NewBook newBook) {
		boolean flag = newBookService.save(newBook);
		return new Result(flag == true ? Code.SAVE_OK : Code.SAVE_ERROR, flag);
	}
	
	@PutMapping
	public Result update(@RequestBody NewBook newBook) {
		boolean flag = newBookService.update(newBook);
		return new Result(flag == true ? Code.UPDATE_OK : Code.UPDATE_ERROR, flag);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Integer id) {
		boolean flag = newBookService.delete(id);
		return new Result(flag == true ? Code.DELETE_OK : Code.DELETE_ERROR, flag);
	}
	
	@GetMapping("/{id}")
	public Result getById(@PathVariable Integer id) {
		NewBook nb = newBookService.getById(id);
		Integer code = nb != null ? Code.GET_OK : Code.GET_ERROR;
		String msg = nb != null ? "OK" : "データクリアに失敗しました、もう一度お試してください";
		return new Result(code, nb, msg);
	}
	
	@GetMapping
	public Result fundAll() {
		List<NewBook> list = newBookService.fundAll();
		Integer code = list != null ? Code.GET_OK : Code.GET_ERROR;
		String msg = list != null ? "OK" : "データクリアに失敗しました、もう一度お試してください";
		return new Result(code, list, msg);
	}
}

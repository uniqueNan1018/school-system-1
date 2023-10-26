package com.school.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.school.model.NewBook;
@Transactional
public interface NewBookService {
	
	/**
	 * 保存
	 * @param newBook
	 * @return
	 */
	public boolean save(NewBook newBook);
	
	/**
	 * 更新
	 * @param newBook
	 * @return
	 */
	public boolean update(NewBook newBook);
	
	/**
	 * IDで削除
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id);
	
	/**
	 * IDで検索
	 * @param id
	 * @return
	 */
	public NewBook getById(Integer id);
	
	/**
	 * 全てを検索
	 * @return
	 */
	public List<NewBook> fundAll();
}

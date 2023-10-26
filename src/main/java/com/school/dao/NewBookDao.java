package com.school.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.school.model.NewBook;

public interface NewBookDao {
	
	@Insert("insert into tb_book values(null, #{type}, #{name}, #{description})")
	public int save(NewBook newBook);
	
	@Update("update tb_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
	public int update(NewBook newBook);
	
	@Delete("delete from tb_book where id = #{id}")
	public int delete(Integer id);
	
	@Select("select type,name,description from tb_book where id = #{id}")
	public NewBook findById(Integer id);
	
	@Select("select id,type,name,description from tb_book")
	public List<NewBook> fundAll();
}

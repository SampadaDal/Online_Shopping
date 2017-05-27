package com.niit.backendshopping.dao;

import java.util.List;

import com.niit.backendshopping.entity.Category;

public interface CategoryDAO {

	Category getCategory(int catID);
	List<Category> getList();
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	
	//Example purpose
	List<Category> list();
}

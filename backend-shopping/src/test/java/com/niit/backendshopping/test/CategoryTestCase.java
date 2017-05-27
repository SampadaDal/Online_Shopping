package com.niit.backendshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backendshopping.dao.CategoryDAO;
import com.niit.backendshopping.entity.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backendshopping");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setCatName("");
		category.setCatDescription("Manual & Automatic available!");
		category.setCatImageURL("washingMachine_1.png");
		
		assertEquals("Failed to add a category!!",true,categoryDAO.addCategory(category));
	}
	
}

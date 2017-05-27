package com.niit.backendshopping.dao;

import java.util.List;

import com.niit.backendshopping.entity.Product;

public interface ProductDAO {

	Product get(int id); //Return the product for the given id!!
	List<Product> list(); //For returning the list of products!!
	boolean add(Product product); //For adding a new product!!
	boolean update(Product product); //For updating a new product!!
	boolean delete(Product product); //For deleting a new product!!
	
	//Business Methods
	List<Product> listOfActiveProducts();
	List<Product> listOfActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}

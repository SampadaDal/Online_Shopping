package com.niit.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.backendshopping.dao.ProductDAO;
import com.niit.backendshopping.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all")
	public @ResponseBody List<Product> allProducts() {
		return productDAO.list();
	}
	
}

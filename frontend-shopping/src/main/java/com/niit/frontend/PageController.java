package com.niit.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backendshopping.dao.CategoryDAO;
import com.niit.backendshopping.dao.ProductDAO;
import com.niit.backendshopping.entity.Category;
import com.niit.backendshopping.entity.Product;
import com.niit.frontend.exception.ProductNotFoundException;

@Controller
public class PageController {

	//Creating a logger object for class PageController
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/index", "/home", "/default" })

	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		 mv.addObject("userClickedHome", true);
		mv.addObject("title", "Home");
	
		logger.info("Inside the index method of PageController class - INFO");
		logger.debug("Inside the index method of PageController class - DEBUG");
		
		//Passing the list of categories
		mv.addObject("categories",categoryDAO.getList());
		return mv;
	}

	// used only for category

	@RequestMapping(value = "/show/all/products")

	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickedAllProducts", true);
		mv.addObject("title", "All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.getList());
		return mv;
	}

	// Used for sidebar to show as Category - ID etc...

	@RequestMapping(value = "/show/category/{id}/products")

	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");

		// Give category name in the title, use CategoryDAO to fetch a single category
		Category category = null;
		//id comes from PathVariable 
		category= categoryDAO.getCategory(id);
		mv.addObject("userClickedCategoryProducts", true);
		
		
		System.out.println("category.getCatName() : " + category.getCatName());
		mv.addObject("title", category.getCatName());
		
		//Passing list of Categories
		mv.addObject("categories", categoryDAO.getList());
		
		//passing a single category
		mv.addObject("category", category);
		return mv;
	}

	@RequestMapping(value = "/about")

	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickedAbout", true);
		mv.addObject("title", "About Us");

		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickedContact", true);
		mv.addObject("title", "Contact Us");
		return mv;
	}

/*	@RequestMapping(value = "/show/all/products")
	public ModelAndView listProduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickedListProducts", true);
		mv.addObject("products", productDAO.list());
		mv.addObject("title", "List Products");
		return mv;
	}*/

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifLoginClicked", true);
		mv.addObject("title", "Login");
		return mv;
	}
	
	
	//for viewing a single product
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView viewSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		
		productDAO.update(product);
		mv.addObject("title",product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickedShowSingleProduct", true);
		return mv;
	}
	
	
}

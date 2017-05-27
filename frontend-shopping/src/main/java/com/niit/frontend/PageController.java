package com.niit.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backendshopping.dao.CategoryDAO;
import com.niit.backendshopping.dao.ProductDAO;
import com.niit.backendshopping.entity.Category;

@Controller
public class PageController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/index", "/home", "/default" })

	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		 mv.addObject("userClickedHome", true);
		mv.addObject("title", "Home");
	
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
}

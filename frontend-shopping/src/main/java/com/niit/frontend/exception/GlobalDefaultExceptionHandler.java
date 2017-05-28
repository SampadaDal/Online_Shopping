package com.niit.frontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	// for 404 Error
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed!");
		mv.addObject("errorDescription", "The page you are looking for is not available right now! :( ");
		mv.addObject("title", "404 Error Page");

		return mv;
	}

	// for Internal server errors like error 500
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The Product is not available");
		mv.addObject("errorDescription", "The Product you are looking for is not available right now! :( ");
		mv.addObject("title", "Product Unavailable!");

		return mv;
	}
	
	// for handling generalized exceptions
		@ExceptionHandler(Exception.class)
		public ModelAndView handleException(Exception ex) {

			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorTitle", "Contact your Administrator!!");
			
			/* 
			 * Only for Debugging the Application!!
			 * */
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			
			mv.addObject("errorDescription", sw.toString());
			//mv.addObject("errorDescription", ex.toString());
			mv.addObject("title", "Error!");

			return mv;
		}
}

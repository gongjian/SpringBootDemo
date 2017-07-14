package com.example.demo.controlleradvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e, WebRequest request) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", e.getMessage());
		
		e.printStackTrace();

		return mv;
	}
	
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("msg", "From @ControllerAdvice msg.");
	}
}

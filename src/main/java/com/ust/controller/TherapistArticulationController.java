package com.ust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.entity.User;
import com.ust.service.api.UserServiceApi;

@Controller
@RequestMapping(value="info")
public class TherapistArticulationController 
{
	
	@Autowired UserServiceApi userServiceApi;
	@RequestMapping (value = "Articulation")
	
	

	 public ModelAndView Articulation(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user)
	 {
	      ModelAndView modelAndView = new ModelAndView("Articulation");
	    
		 
	   return modelAndView;
	  
	 } 
}


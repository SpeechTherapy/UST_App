package com.ust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController
{
	@RequestMapping(value = "homepage")
	public ModelAndView homepage() {
		ModelAndView modelAndView = new ModelAndView("homepage");

		return modelAndView;
	}
}
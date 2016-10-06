package com.ust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "error")
public class ErrorController {

	@RequestMapping(value = "404")
	 public ModelAndView ErrorPage404(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		return new ModelAndView("error404");
   }
	
	@RequestMapping(value = "500")
	 public ModelAndView ErrorPage500(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		return new ModelAndView("error500");
  }
}

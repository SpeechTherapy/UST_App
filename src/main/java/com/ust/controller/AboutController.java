package com.ust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.entity.Therapist;

@Controller
public class AboutController {
	
	@RequestMapping(value="AboutAdmin")
	public ModelAndView AboutAdmin(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("AboutAdmin");
     return modelAndView;
    }
	
	@RequestMapping(value="AboutTherapist")
	public ModelAndView AboutTherapist(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("AboutTherapist");
     return modelAndView;
    }

}

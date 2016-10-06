package com.ust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="information")
public class ArticulationInformationController 
{
	@RequestMapping(value = "ArticulationInformation" , method = RequestMethod.GET)
    public ModelAndView ArticulationInformation() {
        ModelAndView modelAndView = new ModelAndView("ArticulationInformation");

        return modelAndView;
    }
}
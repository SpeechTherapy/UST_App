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

import com.ust.domain.Hospital;
import com.ust.domain.TherapistDomain;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;

@Controller
public class ViewProfileTherapistController
{
	@Autowired TherapistServiceApi therapistserviceApi;
	@Autowired UserServiceApi userServiceApi;

	 @RequestMapping(value = "ViewProfileTherapist", method = RequestMethod.GET)

	 
	 public ModelAndView ViewProfileTherapist(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			 @ModelAttribute User user)
	 {
	   ModelAndView modelAndView;
	   if (request.getSession().getAttribute("userId") != null)
	   {
	    modelAndView = new ModelAndView("ViewProfileTherapist");
	    if(request.getSession().getAttribute("therapistId")!=null)
		 {
            int id=Integer.valueOf((String)request.getSession().getAttribute("therapistId"));

	    	
	Therapist	therapist = therapistserviceApi.findById(id); 
	    TherapistDomain therapistDomain = new TherapistDomain();
	    therapistDomain.setName(therapist.getTherapistName());
	    therapistDomain.setContactNumber(therapist.getTherapistContact());
	    therapistDomain.setTherapistGender(therapist.getTherapistGender());
     	System.out.println("Email :: "+therapist.getUser().getEmail());
     	System.out.println("Hospital :: "+therapist.getHospital().getHospitalName());
     	System.out.println("City :: "+therapist.getHospital().getCity().getCityName());


	    
	    model.addAttribute("therapistName",therapistDomain.getName());
	    model.addAttribute("contactNo",therapistDomain.getContactNumber());
	    model.addAttribute("therapistGender",therapistDomain.getTherapistGender());
	    model.addAttribute("Email",therapist.getUser().getEmail());
	    model.addAttribute("Hospital",therapist.getHospital().getHospitalName());
	    model.addAttribute("Address", therapist.getHospital().getHospitalAddress());
	    model.addAttribute("City",therapist.getHospital().getCity().getCityName());
	      model.addAttribute("userPic", therapist.getUser().getUserPic());


		 }}
	   else
	   {
	    redirectAttributes.addFlashAttribute("message", "Session has been expired please 'Login' Again");
	    modelAndView = new ModelAndView("redirect:/user/LoginUser");
	   }
	   return modelAndView;
	  }
}

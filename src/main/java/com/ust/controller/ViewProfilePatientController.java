package com.ust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.domain.ReportDomain;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.service.api.PatientserviceApi;

@Controller

public class ViewProfilePatientController
{
	@Autowired PatientserviceApi patientserviceApi;
		@RequestMapping(value = "ViewProfilePatient", method = RequestMethod.GET)
public ModelAndView ViewProfilePatient(HttpServletRequest request, Model model , RedirectAttributes redirectAttributes) 
{

ModelAndView  modelAndView = new ModelAndView("ViewProfilePatient");
  if(request.getSession().getAttribute("patientId")!=null)
	 {
     int id=Integer.valueOf((String)request.getSession().getAttribute("patientId"));
	  Patient	patient = patientserviceApi.findById(id);
	
//Patient	patient = patientserviceApi.findById((int)request.getSession().getAttribute("patientId"));
     System.out.println("Testing in function");
     ReportDomain reportDomain =new ReportDomain();
        reportDomain.setPatientName(patient.getPatientName());
        reportDomain.setAge(patient.getPatientAge());
        reportDomain.setContactNum(patient.getContactNum());
        reportDomain.setdOB(patient.getPatientDob());
        reportDomain.setGuardianName(patient.getPatientGuardianName());
        reportDomain.setGender(patient.getPatientGender());
        reportDomain.setDate(patient.getCreatedDate());
        
   model.addAttribute("guardianName",reportDomain.getGuardianName());
      model.addAttribute("age",reportDomain.getAge());
      model.addAttribute("gender",reportDomain.getGender());
      model.addAttribute("patientName",reportDomain.getPatientName());
      model.addAttribute("dOB",reportDomain.getdOB());
      model.addAttribute("contactNum",reportDomain.getContactNum());
      model.addAttribute("Allegies", patient.getAllergies());
      model.addAttribute("Language",patient.getLanguageSpoken());
      model.addAttribute("userPic",patient.getUser().getUserPic());
	 }
  else{
	  System.out.println("In Else Not data fetched");
  }
     
     return modelAndView;
    }

}
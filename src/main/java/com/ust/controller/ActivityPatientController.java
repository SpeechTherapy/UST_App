package com.ust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.entity.Media;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.entity.Words;
import com.ust.service.api.MediaServiceApi;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.UserServiceApi;
import com.ust.service.api.WordsServiceApi;

@Controller

public class ActivityPatientController
{
	@Autowired UserServiceApi userServiceApi;
	@Autowired WordsServiceApi wordsServiceApi;
	@Autowired MediaServiceApi mediaServiceApi;
	@Autowired PatientserviceApi patientServiceApi;
	@RequestMapping(value = "ActivityScreenPatient")

    	 public ModelAndView ActivityScreen(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,@ModelAttribute User user)
    	 {
    	   
		ModelAndView   modelAndView = new ModelAndView("ActivityScreenPatient");
    	    int userId=(int)request.getSession().getAttribute("userId");
    	    user=userServiceApi.findById(userId);
    		int patientId = (int) request.getSession().getAttribute("loginId");
    		Patient patient = patientServiceApi.findById(patientId);
    		if (request.getSession().getAttribute("userId") != null) {
    		
					if (patient != null) {
						System.out.println("Patient Name ::" + patient.getCreatedDate());
						model.addAttribute("patientName", patient.getPatientName());
						model.addAttribute("createdOn", patient.getCreatedDate());
						model.addAttribute("email", patient.getUser().getEmail());
						model.addAttribute("contactNo", patient.getContactNum());
						model.addAttribute("userPic", patient.getUser().getUserPic());
						model.addAttribute("guradianName", patient.getPatientGuardianName());
						
						model.addAttribute("therapistName", patient.getTherapist().getTherapistName());
						model.addAttribute("CreatedOn", patient.getTherapist().getCreatedDate());
						model.addAttribute("Email", patient.getTherapist().getUser().getEmail());
						model.addAttribute("Hospital", patient.getTherapist().getHospital().getHospitalName());
						model.addAttribute("contactNo", patient.getTherapist().getTherapistContact());
						model.addAttribute("UserPic", patient.getTherapist().getUser().getUserPic());

					}
					if(request.getSession().getAttribute("ID")!=null)
					 {
						 Words word=new Words();
							word = wordsServiceApi.findById((int) request.getSession().getAttribute("ID"));
				    		 Media media=mediaServiceApi.findById(word.getMedia().getMediaId());
				    		 System.out.println("Media ID :: "+word.getMedia().getMediaId());
				    		 System.out.println("Media Audio ::"+word.getMedia().getMediaAudio());
				    		 System.out.println("Media Audio ::"+word.getMedia().getMediaImage());
		model.addAttribute("mediaImage", word.getMedia().getMediaImage());
		model.addAttribute("mediaAudio", word.getMedia().getMediaAudio());

						//	System.out.println("Media id"+wordMedia.getMedia().getMediaAudio());
							//SoundRecordingUtil soundRecordingUtil = new SoundRecordingUtil();
							
							
					 }
				}
			

				
			return modelAndView;


       
    	 }
   
}

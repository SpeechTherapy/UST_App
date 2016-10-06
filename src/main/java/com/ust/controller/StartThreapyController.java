package com.ust.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.entity.Lesson;
import com.ust.entity.Media;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.entity.Words;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.MediaServiceApi;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;
import com.ust.service.api.WordsServiceApi;

import net.codejava.sound.SoundRecordingUtil;
import net.codejava.sound.TestSoundRecordingUtil;

@Controller

public class StartThreapyController
{
	@Autowired UserServiceApi userServiceApi;
	@Autowired WordsServiceApi wordsServiceApi;
	@Autowired MediaServiceApi mediaServiceApi;
	@Autowired LessonServiceApi lessonServiceApi;
	@Autowired TherapistServiceApi therapistServiceApi;
	@Autowired PatientserviceApi patientServiceApi;
	
	@RequestMapping(value = "StartActivityTherapist")

    	 public ModelAndView ActivityScreen(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,@ModelAttribute User user)
    	 {
    	   
		ModelAndView   modelAndView = new ModelAndView("StartActivityTherapist");
    	    
    	    int userId=(int)request.getSession().getAttribute("userId");
    	    user=userServiceApi.findById(userId);
    		int therapistId = (int) request.getSession().getAttribute("loginId");
    		Therapist therapist1 = therapistServiceApi.findById(therapistId);
    	    if (user.getTherapist() != null && user.getTherapist().size() > 0 && user.getUserIsActive()!=0)
			{
				System.out.println("In therapist");

				for (Therapist therapist : user.getTherapist())
				{
					request.getSession().setAttribute("loginId", therapist.getTherapistId());
					System.out.println("Therapist"+therapist.getTherapistId());
					System.out.println("Therapist Name ::"+therapist.getTherapistName());
					model.addAttribute("therapistName", therapist.getTherapistName());
					model.addAttribute("CreatedOn", therapist.getCreatedDate());
					model.addAttribute("Email", therapist.getUser().getEmail());
				//	model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
					model.addAttribute("contactNo", therapist.getTherapistContact());
					model.addAttribute("UserPic", therapist.getUser().getUserPic());				}
				
				
				
			 if(request.getSession().getAttribute("lessonId")!=null)
			 {
					Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));

model.addAttribute("lesson", lessons.getLesson());
model.addAttribute("videoRefrence", lessons.getVideoReference());
model.addAttribute("lessonPic", lessons.getLessonPic());
					
					
			 }
			 
			 //return welcome;
				
			}
			System.out.println("Check complete");

				
			return modelAndView;
    	 }
   
	
	

	@RequestMapping(value = "StartActivityPatient")

    	 public ModelAndView StartActivityPatient(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,@ModelAttribute User user)
    	 {
    	   
		ModelAndView   modelAndView = new ModelAndView("StartActivityPatient");
    	    
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

			 if(request.getSession().getAttribute("AssignedLessonId")!=null)
			 {
					Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("AssignedLessonId"));

model.addAttribute("lesson", lessons.getLesson());
model.addAttribute("videoRefrence", lessons.getVideoReference());
model.addAttribute("lessonPic", lessons.getLessonPic());
					
					
			 }
					}
			 //return welcome;
				
			}
			System.out.println("Check complete");

				
			return modelAndView;
    	 }
   
	
	

}

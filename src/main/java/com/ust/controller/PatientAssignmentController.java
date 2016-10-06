package com.ust.controller;

import java.util.HashMap;
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
import com.ust.entity.Patient;
import com.ust.entity.Sounds;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.entity.Words;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.PatientserviceApi;

@Controller
public class PatientAssignmentController {
	@Autowired PatientserviceApi patientServiceApi;
	@Autowired LessonServiceApi lessonServiceApi;
	
	
	@RequestMapping(value="PatientSound")
	public ModelAndView PatientSound(Model model, HttpServletRequest request)
	{
		ModelAndView modelAndView=new ModelAndView("PatientSound");
	    int userId = (int) request.getSession().getAttribute("userId");
		int patientId = (int) request.getSession().getAttribute("loginId");
		Patient patient = patientServiceApi.findById(patientId);
		if (patient != null)
		{
		
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
		             
			   System.out.println(" Sound Lesson ID::"+request.getSession().getAttribute("AssignedLessonId"));
				 if(request.getSession().getAttribute("AssignedLessonId")!=null)
				 {
			Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("AssignedLessonId"));
			System.out.println("Sound Testing :: "+lessons.getSounds());
			for(Sounds sound:lessons.getSounds())
			{
				if(sound.getSoundIsActive()>0){
				System.out.println("Sound Name  ::" +sound.getSound());
				System.out.println("Sound Audio :: "+sound.getMedia().getMediaAudio());
				model.addAttribute("soundList",lessons.getSounds());
				model.addAttribute("soundsId",sound.getSoundsId());
				model.addAttribute("soundName", sound.getSound());
			    model.addAttribute("soundIsActive",sound.getSoundIsActive());
			   /* model.addAttribute("mediaAudio",sound.getMedia().getMediaAudio()*/
				}
			}
				 }
					}
				 
				
			 
		   return modelAndView;
		  
		 }
		
	@RequestMapping(value = "WordsId", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> SetLessonId(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("WordsID")) {
			request.getSession().setAttribute("ID", map.get("WordsID"));
			System.out.println("Words Id :: "+request.getSession().getAttribute("ID"));
			

		}

		return result;

	}

		
	
	
	@RequestMapping(value="PatientWord")
	public ModelAndView PatientWord(Model model,HttpServletRequest request)
	{
		ModelAndView modelAndView=new ModelAndView("PatientWord");

		   int userId = (int) request.getSession().getAttribute("userId");
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

					
					
					System.out.println("Patient"+patient.getPatientId());
					System.out.println("Patient Name ::"+patient.getPatientName());
		            

	            
		   System.out.println(" Word Lesson ID::"+request.getSession().getAttribute("AssignedLessonId"));
			 if(request.getSession().getAttribute("AssignedLessonId")!=null)
			 {
		Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("AssignedLessonId"));
		for(Words word:lessons.getWords())
		{
			if(word.getWordIsActive()>0){
			System.out.println("words Name  ::" +word.getWords());
			model.addAttribute("wordsList",lessons.getWords());
			model.addAttribute("wordsId",word.getWordsId());
			model.addAttribute("wordIsActive", word.getWordIsActive());
			}
		}
			 }
				}
			 }else{
				 System.out.println("Testing");
			 }
		   return modelAndView;
	
	
	}
	

	@RequestMapping(value = "SetId", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> SetId(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("AssignedLessonId")) {
			System.out.println("AssignedLessonId Checkinggggg:: " + map.get("AssignedLessonId"));
			request.getSession().setAttribute("AssignedLessonId", map.get("AssignedLessonId"));

		}

		return result;

	}

}

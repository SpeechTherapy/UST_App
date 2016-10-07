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
import com.ust.entity.Sentences;
import com.ust.entity.Sounds;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.entity.Words;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;

@Controller
public class TherapistLessonsController
{
	@Autowired UserServiceApi userServiceApi;
	@Autowired TherapistServiceApi therapistServiceApi;
	
	@RequestMapping (value = "TherapistWord")

	 public ModelAndView TherapistWord(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user)
	 {
	   ModelAndView modelAndView = new ModelAndView("TherapistWord");
	   int userId = (int) request.getSession().getAttribute("userId");
		int therapistId = (int) request.getSession().getAttribute("loginId");
		Therapist therapist = therapistServiceApi.findById(therapistId);
		if (request.getSession().getAttribute("userId") != null) {
			if (therapist != null) {
				System.out.println("Therapist Name ::" + therapist.getTherapistName());
				model.addAttribute("therapistName", therapist.getTherapistName());
				model.addAttribute("CreatedOn", therapist.getCreatedDate());
				model.addAttribute("Email", therapist.getUser().getEmail());
				model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
				model.addAttribute("contactNo", therapist.getTherapistContact());
				model.addAttribute("UserPic", therapist.getUser().getUserPic());

            
	   System.out.println(" Word Lesson ID::"+request.getSession().getAttribute("lessonId"));
		 if(request.getSession().getAttribute("lessonId")!=null)
		 {System.out.println("Lesson ID in Words :: "+request.getSession().getAttribute("lessonId"));
			 
	Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));
	for(Words word:lessons.getWords())
	{
		if(word.getWordIsActive()>0){
		System.out.println("Sound Name  ::" +word.getWords());
		model.addAttribute("wordsList",lessons.getWords());
		model.addAttribute("wordsId",word.getWordsId());
		}
	}
		 }
			}
		 }else{
			 System.out.println("Testing");
		 }
	   return modelAndView;
	  
	 } 
	
	@RequestMapping(value = "SetWordsId", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> SetLessonId(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("wordsId")) {
			System.out.println("wordsId Checkinggggg:: " + map.get("wordsId"));
			request.getSession().setAttribute("wordsId", map.get("wordsId"));

		}

		return result;

	}

	
	@Autowired LessonServiceApi lessonServiceApi;
	@RequestMapping (value = "TherapistSound")

	 public ModelAndView TherapistSound(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user)
	 {
	   ModelAndView modelAndView = new ModelAndView("TherapistSound");
	   int userId = (int) request.getSession().getAttribute("userId");
		int therapistId = (int) request.getSession().getAttribute("loginId");
		Therapist therapist = therapistServiceApi.findById(therapistId);
		if (request.getSession().getAttribute("userId") != null) {
			if (therapist != null) {
				System.out.println("Therapist Name ::" + therapist.getTherapistName());
				model.addAttribute("therapistName", therapist.getTherapistName());
				model.addAttribute("CreatedOn", therapist.getCreatedDate());
				model.addAttribute("Email", therapist.getUser().getEmail());
				model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
				model.addAttribute("contactNo", therapist.getTherapistContact());
				model.addAttribute("UserPic", therapist.getUser().getUserPic());

             
	   System.out.println(" Sound Lesson ID::"+request.getSession().getAttribute("lessonId"));
		 if(request.getSession().getAttribute("lessonId")!=null)
		 {
	Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));
	System.out.println("Sound Testing :: "+lessons.getSounds());
	for(Sounds sound:lessons.getSounds())
	{
		if(sound.getSoundIsActive()>0){
		System.out.println("Sound Name  ::" +sound.getSound());
		System.out.println("Sound Audio :: "+sound.getMedia().getMediaAudio());
		model.addAttribute("soundList",lessons.getSounds());
		model.addAttribute("soundsId",sound.getSoundsId());
	    model.addAttribute("soundIsActive",sound.getSoundIsActive());
	   /* model.addAttribute("mediaAudio",sound.getMedia().getMediaAudio()*/
		}
	}
		 }
			}}else{
				System.out.println("Sound Testing");
			 }
			
		 
	   return modelAndView;
	  
	 }
	@RequestMapping (value = "TherapistSelection")

	 public ModelAndView TherapistSelection(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user)
	 {
	
	ModelAndView modelAndView = new ModelAndView("TherapistSelection");
	int userId = (int) request.getSession().getAttribute("userId");
	int therapistId = (int) request.getSession().getAttribute("loginId");
	Therapist therapist = therapistServiceApi.findById(therapistId);
	if (request.getSession().getAttribute("userId") != null) {
		if (therapist != null) {
			System.out.println("Therapist Name ::" + therapist.getTherapistName());
			model.addAttribute("therapistName", therapist.getTherapistName());
			model.addAttribute("CreatedOn", therapist.getCreatedDate());
			model.addAttribute("Email", therapist.getUser().getEmail());
			model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
			model.addAttribute("contactNo", therapist.getTherapistContact());
			model.addAttribute("UserPic", therapist.getUser().getUserPic());

              }
			}
			
	  
	 
		return modelAndView; 
}
	
	
	@RequestMapping (value = "TherapistSentence")

	 public ModelAndView TherapistSentence(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user)
	 {
	   ModelAndView modelAndView = new ModelAndView("TherapistSentence");
	   int userId = (int) request.getSession().getAttribute("userId");
		int therapistId = (int) request.getSession().getAttribute("loginId");
		Therapist therapist = therapistServiceApi.findById(therapistId);
		if (request.getSession().getAttribute("userId") != null) {
			if (therapist != null) {
				System.out.println("Therapist Name ::" + therapist.getTherapistName());
				model.addAttribute("therapistName", therapist.getTherapistName());
				model.addAttribute("CreatedOn", therapist.getCreatedDate());
				model.addAttribute("Email", therapist.getUser().getEmail());
				model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
				model.addAttribute("contactNo", therapist.getTherapistContact());
				model.addAttribute("UserPic", therapist.getUser().getUserPic());

           
	   System.out.println(" Sentence Lesson ID::"+request.getSession().getAttribute("lessonId"));
		 if(request.getSession().getAttribute("lessonId")!=null)
		 {
			 System.out.println("Lesson ID in Sentence :: "+request.getSession().getAttribute("lessonId"));
			 
	Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));
	for(Sentences sentence:lessons.getSentences())
	{
		if(sentence.getSentencesIsActive()>0){
		System.out.println("Sentence Name  ::" +sentence.getSentences());
		model.addAttribute("sentencesList",lessons.getSentences());
		model.addAttribute("sentencesId",sentence.getSentencesId());
		}
	}
		 }
			}
		 }else{
			 System.out.println("Testing");
		 }
	   return modelAndView;
	  
	 } 
	
	@RequestMapping(value = "SetSentencesId", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> SetSentencesId(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("sentencesId")) {
			System.out.println("sentencesId Checkinggggg:: " + map.get("sentencesId"));
			request.getSession().setAttribute("sentencesId", map.get("sentencesId"));

		}

		return result;

	}
	
	
}
	
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
import com.ust.service.api.MediaServiceApi;
import com.ust.service.api.UserServiceApi;
import com.ust.service.api.WordsServiceApi;

import net.codejava.sound.SoundRecordingUtil;
import net.codejava.sound.TestSoundRecordingUtil;

@Controller

public class ActivityController
{
	@Autowired UserServiceApi userServiceApi;
	@Autowired WordsServiceApi wordsServiceApi;
	@Autowired MediaServiceApi mediaServiceApi;
	@RequestMapping(value = "ActivityScreen")

    	 public ModelAndView ActivityScreen(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,@ModelAttribute User user)
    	 {
    	   
		ModelAndView   modelAndView = new ModelAndView("ActivityScreen");
    	    int userId=(int)request.getSession().getAttribute("userId");
    	    user=userServiceApi.findById(userId);
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
					//model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
					model.addAttribute("contactNo", therapist.getTherapistContact());
					model.addAttribute("UserPic", therapist.getUser().getUserPic());				}
				
				
				
			 if(request.getSession().getAttribute("wordsId")!=null)
			 {
				 Words word=new Words();
					word = wordsServiceApi.findById((int) request.getSession().getAttribute("wordsId"));
		    		 Media media=mediaServiceApi.findById(word.getMedia().getMediaId());
		    		 System.out.println("Media ID :: "+word.getMedia().getMediaId());
		    		 System.out.println("Media Audio ::"+word.getMedia().getMediaAudio());
		    		 System.out.println("Media Audio ::"+word.getMedia().getMediaImage());
model.addAttribute("mediaImage", word.getMedia().getMediaImage());
model.addAttribute("mediaAudio", word.getMedia().getMediaAudio());

				//	System.out.println("Media id"+wordMedia.getMedia().getMediaAudio());
					//SoundRecordingUtil soundRecordingUtil = new SoundRecordingUtil();
					
					
			 }
			 
			 //return welcome;
				
			}
			System.out.println("Check complete");

				
			return modelAndView;
    	 }
   
	
	
	//Audio Recorder Function 
	
	
	@RequestMapping(value = "AudioRecorder", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> AudioRecorder(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("Yes")) {
			TestSoundRecordingUtil testSoundRecordingUtil = new TestSoundRecordingUtil();
			testSoundRecordingUtil.mainMethod();
			System.out.println("testing recording");
		}

		return result;

	}

	
	@RequestMapping(value="AdminEditActivityScreen")
	public ModelAndView AdminEditActivityScreen(Model model)
	{
		ModelAndView modelAndView=new ModelAndView("AdminEditActivityScreen");
		return modelAndView;
	}
	
}

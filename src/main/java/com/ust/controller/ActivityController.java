package com.ust.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.domain.LessonDomain;
import com.ust.domain.SentencesDomain;
import com.ust.entity.Lesson;
import com.ust.entity.Media;
import com.ust.entity.Patient;
import com.ust.entity.Sentences;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.entity.Words;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.MediaServiceApi;
import com.ust.service.api.SentencesServiceApi;
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
	@Autowired SentencesServiceApi sentencesServiceApi;
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

				
					
			 }
			 
			 else if(request.getSession().getAttribute("sentencesId")!=null)
			 {
				 Sentences sentence=sentencesServiceApi.findById((int)request.getSession().getAttribute("sentencesId"));
				 model.addAttribute("mediaImage", sentence.getMedia().getMediaImage());
				 model.addAttribute("mediaAudio", sentence.getMedia().getMediaAudio());
			 }
				
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

	@Autowired LessonServiceApi lessonServiceApi;
	
	@RequestMapping(value="AdminEditActivityScreen")
	public ModelAndView AdminEditActivityScreen(Model model,HttpServletRequest request)
	{
		ModelAndView modelAndView=new ModelAndView("AdminEditActivityScreen");
		if(request.getSession().getAttribute("lessonId")!=null)
		 {
	Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));
if(lessons !=null)	{
		System.out.println("Lesson Id  ::" +lessons.getLessonId());
		System.out.println("Lesson Name  ::" +lessons.getLesson());
		System.out.println("Lesson Pic  ::" +lessons.getLessonPic());
		System.out.println("Lesson Video Reference  ::" +lessons.getVideoReference());
		model.addAttribute("lessonPic", lessons.getLessonPic());
		model.addAttribute("videoRefrence", lessons.getVideoReference());




	}
		 }
		return modelAndView;
	}
	
	@RequestMapping(value = "activityEdit",method= RequestMethod.POST)
	public @ResponseBody

    ModelAndView sentenceEdit(@ModelAttribute LessonDomain lessonDomain,Model model, HttpServletRequest request ,
    		@RequestParam(value="image", required = false) MultipartFile file,
    		@RequestParam(value="video", required = false) MultipartFile files,
    		RedirectAttributes redirectAttributes ) throws ParseException
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/AdminEditActivityScreen");
		System.out.println("Test");
	
		 
        if (lessonDomain.getLesson().contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
			return modelAndView;
		}
		if (lessonDomain.getLesson().contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
			return modelAndView;
		}
		
    		String imageLocation = null;
    		String videoLocation = null;

    		if (file!=null) {
    			try {
    				imageLocation = "C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+"-"+file.getOriginalFilename().replace(" ", "-");
    				videoLocation = "C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+"-"+files.getOriginalFilename().replace(" ", "-");
    				BufferedOutputStream stream = new BufferedOutputStream(
    						new FileOutputStream(new File(imageLocation)));
    				BufferedOutputStream streams = new BufferedOutputStream(
    						new FileOutputStream(new File(videoLocation)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
                    FileCopyUtils.copy(files.getInputStream(), streams);

    				stream.close();
    				lessonDomain.setLessonPic("static-images/" +"-"+file.getOriginalFilename().replace(" ", "-"));
    				
    				lessonDomain.setVideoReference("static-images/" +"-"+files.getOriginalFilename().replace(" ", "-"));

    			}
    			catch (Exception e) {
    				redirectAttributes.addFlashAttribute("message",
    						"You failed to upload  => " + e.getMessage());
    			}
    		}
    		else {
    			redirectAttributes.addFlashAttribute("message",
    					"You failed to upload  because the file was empty");
    		}
    	

  	        Lesson lesson = new Lesson();
  	        lessonServiceApi.findById((int)request.getSession().getAttribute("lessonId"));
  	        lesson.setLessonId((int) request.getSession().getAttribute("lessonId"));
  			System.out.println(lesson.getLesson());
  	        lesson.setLesson(lessonDomain.getLesson());
  	        lesson.setLessonPic(lessonDomain.getLessonPic());
  	        lesson.setVideoReference(lessonDomain.getVideoReference());
  	        lessonServiceApi.saveOrUpdate(lesson);
  	        
             
  	        
            
            return modelAndView;
        }
     
	
	
}

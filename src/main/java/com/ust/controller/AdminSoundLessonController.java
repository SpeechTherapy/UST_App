package com.ust.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.ust.domain.MediaDomain;
import com.ust.domain.SoundsDomain;
import com.ust.domain.TherapistDomain;
import com.ust.entity.City;
import com.ust.entity.Hospital;
import com.ust.entity.Lesson;
import com.ust.entity.Media;
import com.ust.entity.Patient;
import com.ust.entity.Sounds;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.MediaServiceApi;
import com.ust.service.api.SoundsServiceApi;

@Controller
public class AdminSoundLessonController {
	@Autowired SoundsServiceApi soundsServiceApi;
	@Autowired MediaServiceApi mediaServiceApi;
	

	@Autowired LessonServiceApi lessonServiceApi;

	@RequestMapping(value="SoundsAdminLesson")
	public ModelAndView SoundsAdminLesson(Model model , HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("SoundsAdminLesson");
	
		System.out.println(" Sound Lesson ID::"+request.getSession().getAttribute("lessonId"));
		 if(request.getSession().getAttribute("lessonId")!=null)
		 {
	Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));
	for(Sounds sound:lessons.getSounds())
	{
		System.out.println("Sound Name  ::" +sound.getSound());
		model.addAttribute("soundList",lessons.getSounds());
		model.addAttribute("soundsId",sound.getSoundsId());
	    model.addAttribute("soundIsActive",sound.getSoundIsActive());

	}
		
		 }
		return modelAndView;
	}
		@RequestMapping(value="DeactivateSounds", method=RequestMethod.POST)
		public @ResponseBody Map<String,Object> Deactivate(@RequestBody Map<String,Object> map)
				
		{
			Map<String,Object> result = new HashMap<String, Object>();
	        Map<String,Object> header = new HashMap<String, Object>();
	        System.out.println("Testing Service");
	        Sounds sound= new Sounds();

	        if(map.containsKey("soundsId"))
	        {
	            System.out.println("soundsId:: "+map.get("soundsId"));
	            System.out.println("soundsIsActive:: "+map.get("isActive"));

	            int id=Integer.valueOf((String)map.get("soundsId"));
	            sound= soundsServiceApi.findById((id));

	            if (sound == null)
	            {
	            	System.out.println("Sound not found"); 
	                header.put("message", "Sound doesnot exist");
	                header.put("status",200);
	            } 
	            else
	            {
	            	if(map.containsKey("isActive") && map.containsKey("soundsId") )
	            	{
	            	sound.setSoundIsActive((int)map.get("isActive"));
	            	soundsServiceApi.saveOrUpdate(sound);
	                header.put("message", "The requested Sound is deactivated/activated... Thanks !!");
	                header.put("status",404);
	            	}
	            	else
	            	{
	            		
	            	}
	            }
	        }
	        else
	        {
	            header.put("message","please select the Sound first");
	        }

	        result.put("header",header);

	        return result;
			
		}
		
	      
		@RequestMapping(value = "sounds", method=RequestMethod.POST)
	    public ModelAndView sounds(
	                                         @RequestParam("audio") MultipartFile audio,
	                                         @RequestParam("name") String str , HttpServletRequest request,
	                                         @ModelAttribute MediaDomain mediaDomain
	    ){
ModelAndView modelAndView=new ModelAndView("redirect:SoundsAdminLesson");

	        if (audio!= null && !audio.isEmpty()){
	            File audioF = new File("C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+audio.getOriginalFilename().replace(" ", "-"));

	            try{
	   
	                /**Save Audio in resource*/
	                audioF.createNewFile();
	                FileOutputStream fos = new FileOutputStream(audioF);
	                fos.write(audio.getBytes());
    				
	                fos.close();

	            }catch(Exception ex){
	                System.out.println("Exception Error");
	            }
	        }else{
	            System.out.println("In Else");
	        }
	        
	        
	        Media media=new Media() ;

	        Lesson lesson = new Lesson();
	        lesson.setLessonId((int) request.getSession().getAttribute("lessonId"));
	      
	        mediaDomain.setMediaAudio("static-images/"+audio.getOriginalFilename().replace(" ", "-"));
	        media.setMediaAudio(mediaDomain.getMediaAudio());
	      
	        mediaServiceApi.save(media);
	        Sounds sound=new Sounds();
			sound.setLesson(lesson);
	        sound.setSound(str);
	        sound.setMedia(media);
	        soundsServiceApi.save(sound);
	        
	        System.out.println("SoundID :: "+sound.getSoundsId());
	        System.out.println("MediaId :: "+media.getMediaId());
           
	        
	        
	        return modelAndView;
	    }
		
		
		
		@RequestMapping(value = "editSound",method= RequestMethod.POST)
		public @ResponseBody

	    ModelAndView editSound(@ModelAttribute SoundsDomain soundDomain,Model model, HttpServletRequest request ,
	    		@RequestParam(value="user_audio", required = false) MultipartFile files,
	    		RedirectAttributes redirectAttributes ) throws ParseException
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/SoundsAdminLesson");
			
		        
		        if (soundDomain.getSoundName().contains("/")) {
	    			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
	    			return modelAndView;
	    		}
	    		if (soundDomain.getSoundName().contains("/")) {
	    			redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
	    			return modelAndView;
	    		}

	    		String audioLocation = null;

	    		if (files!=null) {
	    			try {
	    				audioLocation = "C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+"-"+files.getOriginalFilename().replace(" ", "-");
	    			
	    				BufferedOutputStream streams = new BufferedOutputStream(
	    						new FileOutputStream(new File(audioLocation)));
	                    FileCopyUtils.copy(files.getInputStream(), streams);

	    				streams.close();
	    				soundDomain.setAudio("static-images/" +"-"+files.getOriginalFilename().replace(" ", "-"));

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
	    		Sounds sound=soundsServiceApi.findById(soundDomain.getSoundsId());
	    		 Media media=mediaServiceApi.findById(sound.getMedia().getMediaId());
System.out.println("SoundDomain ::"+soundDomain.getSoundsId());

	  	        Lesson lesson = new Lesson();
	  	        lesson.setLessonId((int) request.getSession().getAttribute("lessonId"));
	  			
	  	      System.out.println(sound.getMedia().getMediaId());
	  	      System.out.println("Audio " +soundDomain.getAudio());
	  	        System.out.println("SoundID :: "+sound.getSoundsId());
	  	        
	  	        
	  	        media.setMediaAudio(soundDomain.getAudio());
	  	        mediaServiceApi.saveOrUpdate(media);
	  	      sound.setLesson(lesson);
	  	        sound.setSound(soundDomain.getSoundName());
	  	        sound.setMedia(media);
	  	        soundsServiceApi.saveOrUpdate(sound);
	  	        
	             
	  	        
	            
	            return modelAndView;
	        }
	     

}


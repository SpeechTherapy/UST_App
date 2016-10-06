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
import org.springframework.util.StringUtils;
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
import com.ust.domain.MediaDomain;
import com.ust.domain.WordsDomain;
import com.ust.domain.WordsDomain;
import com.ust.domain.TherapistDomain;
import com.ust.entity.City;
import com.ust.entity.Hospital;
import com.ust.entity.Lesson;
import com.ust.entity.Media;
import com.ust.entity.Sentences;
import com.ust.entity.Words;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.entity.Words;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.MediaServiceApi;
import com.ust.service.api.SentencesServiceApi;
import com.ust.service.api.WordsServiceApi;
import com.ust.service.api.WordsServiceApi;

@Controller
public class AdminWordLessonController {
	
	@Autowired WordsServiceApi wordsServiceApi;
	@Autowired LessonServiceApi lessonServiceApi;
	@Autowired MediaServiceApi mediaServiceApi;
		
		@RequestMapping(value="WordsAdminLesson")
		public ModelAndView WordsAdminLesson(Model model, HttpServletRequest request) {
			ModelAndView modelAndView = new ModelAndView("WordsAdminLesson");
			System.out.println(" Words Lesson ID::"+request.getSession().getAttribute("lessonId"));
			 if(request.getSession().getAttribute("lessonId")!=null)
			 {
		Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));
		for(Words words:lessons.getWords())
		{
			System.out.println("Word Name  ::" +words.getWords());
			model.addAttribute("wordsList",lessons.getWords());
			model.addAttribute("wordsId",words.getWordsId());
		    model.addAttribute("wordIsActive",words.getWordIsActive());

		}
			
			 }

			return modelAndView;
	}
		
		@RequestMapping(value="DeactivateWords", method=RequestMethod.POST)
		public @ResponseBody Map<String,Object> DeactivateWords(@RequestBody Map<String,Object> map)
		{
			Map<String,Object> result = new HashMap<String, Object>();
	        Map<String,Object> header = new HashMap<String, Object>();


	        if(map.containsKey("wordsId")) {
	            System.out.println("wordsId:: "+map.get("wordsId"));
	            System.out.println("wordsIsActive:: "+map.get("isActive"));

	            int id=Integer.valueOf((String)map.get("wordsId"));
	            Words word= wordsServiceApi.findById((id));

	            if (word == null) {
	            	System.out.println("Word not found");
	                    header.put("message", "Word doesnot exist");
	                    header.put("status",200);
	            } else {
	            	if(map.containsKey("isActive"))
	            	{
	            	word.setWordIsActive((int)map.get("isActive"));
	            	wordsServiceApi.saveOrUpdate(word);
	                header.put("message", "The requested word is activated/deactivted... Thanks !!");
	                header.put("status",404);}
	            	else{
	            		
	            		System.out.println("Testing");
	            	}
	            }
	        }else{
	            header.put("message","please select the Word first");
	        }

	        result.put("header",header);

	        return result;
			
		}
		
		
		@RequestMapping(value = "uploadWord", method=RequestMethod.POST)
	    public ModelAndView fileUpload(@RequestParam("image") MultipartFile image,
	                                         @RequestParam("audio") MultipartFile audio,
	                                         @RequestParam("name") String str , HttpServletRequest request,
	                                         @ModelAttribute MediaDomain mediaDomain
	    ){

			ModelAndView modelAndView=new ModelAndView("redirect:WordsAdminLesson");

	        if (image!= null && !image.isEmpty()){
	            File imageF = new File("C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+image.getOriginalFilename().replace(" ", "-"));
	            File audioF = new File("C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+audio.getOriginalFilename().replace(" ", "-"));

	            try{
	                /**Save Image in resource*/
	                imageF.createNewFile();
	                FileOutputStream fos = new FileOutputStream(imageF);
	                fos.write(image.getBytes());
    			   

	                fos.close();

	                /**Save Audio in resource*/
	                audioF.createNewFile();
	                fos = new FileOutputStream(audioF);
	                fos.write(audio.getBytes());
    				
	                fos.close();

	            }catch(Exception ex){
	                System.out.println("Exception Error");
	            }
	        }else{
	            System.out.println("Else Error");
	        }
	        
	        
	        Media media=new Media() ;

	        Lesson lesson = new Lesson();
	        lesson.setLessonId((int) request.getSession().getAttribute("lessonId"));
	      
	        mediaDomain.setMediaAudio("static-images/"+audio.getOriginalFilename().replace(" ", "-"));
	        media.setMediaAudio(mediaDomain.getMediaAudio());
	        mediaDomain.setMediaImage("static-images/"+image.getOriginalFilename().replace(" ", "-"));
	        media.setMediaImage(mediaDomain.getMediaImage());
	        mediaServiceApi.save(media);
	        Words word=new Words();
			word.setLesson(lesson);
	        word.setWords(str);
	        word.setMedia(media);
	        wordsServiceApi.save(word);
	        
	        System.out.println("WordsID :: "+word.getWordsId());
	        System.out.println("MediaId :: "+media.getMediaId());
           
	        
	        
	        return modelAndView;
	    }
		@RequestMapping(value = "wordEdit",method= RequestMethod.POST)
		public @ResponseBody

	    ModelAndView wordEdit(@ModelAttribute WordsDomain wordDomain,Model model, HttpServletRequest request ,
	    		@RequestParam(value="pic", required = false) MultipartFile file,
	    		@RequestParam(value="user_audio", required = false) MultipartFile files,
	    		RedirectAttributes redirectAttributes ) throws ParseException
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/WordsAdminLesson");
			
		        
		        if (wordDomain.getWordsName().contains("/")) {
	    			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
	    			return modelAndView;
	    		}
	    		if (wordDomain.getWordsName().contains("/")) {
	    			redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
	    			return modelAndView;
	    		}

	    		String imageLocation = null;
	    		String audioLocation = null;

	    		if (file!=null) {
	    			try {
	    				imageLocation = "C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+"-"+file.getOriginalFilename().replace(" ", "-");
	    				audioLocation = "C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+"-"+files.getOriginalFilename().replace(" ", "-");
	    				BufferedOutputStream stream = new BufferedOutputStream(
	    						new FileOutputStream(new File(imageLocation)));
	    				BufferedOutputStream streams = new BufferedOutputStream(
	    						new FileOutputStream(new File(audioLocation)));
	                    FileCopyUtils.copy(file.getInputStream(), stream);
	                    FileCopyUtils.copy(files.getInputStream(), streams);

	    				stream.close();
	    				wordDomain.setMediaPic("static-images/" +"-"+file.getOriginalFilename().replace(" ", "-"));
	    				wordDomain.setAudio("static-images/" +"-"+files.getOriginalFilename().replace(" ", "-"));

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
	    		Words word=wordsServiceApi.findById(wordDomain.getWordsId());
	    		 Media media=mediaServiceApi.findById(word.getMedia().getMediaId());
System.out.println("wordDomain ::"+word.getMedia().getMediaId());

	  	        Lesson lesson = new Lesson();
	  	        lesson.setLessonId((int) request.getSession().getAttribute("lessonId"));
	  			
	  	      System.out.println(word.getMedia().getMediaId());
	  	      System.out.println("Audio " +wordDomain.getAudio());
	  	        System.out.println("Video"+ wordDomain.getMediaPic());
	  	        
	  	        
	  	        media.setMediaAudio(wordDomain.getAudio());
	  	        media.setMediaImage(wordDomain.getMediaPic());
	  	        mediaServiceApi.saveOrUpdate(media);
	  	      word.setLesson(lesson);
	  	        word.setWords(wordDomain.getWordsName());
	  	        word.setMedia(media);
	  	        wordsServiceApi.saveOrUpdate(word);
	  	        
	             
	  	        
	            
	            return modelAndView;
	        }
	     

		
		
}

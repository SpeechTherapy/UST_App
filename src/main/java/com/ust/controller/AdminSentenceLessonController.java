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

import com.ust.domain.MediaDomain;
import com.ust.domain.SentencesDomain;
import com.ust.domain.SoundsDomain;
import com.ust.entity.Lesson;
import com.ust.entity.Media;
import com.ust.entity.Sentences;
import com.ust.entity.Sounds;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.MediaServiceApi;
import com.ust.service.api.SentencesServiceApi;

@Controller
public class AdminSentenceLessonController {
	
	@Autowired SentencesServiceApi sentencesServiceApi;
	@Autowired LessonServiceApi lessonServiceApi;
	@Autowired MediaServiceApi mediaServiceApi;
	
	@RequestMapping(value="SentencesAdminLesson")
	public ModelAndView SentencesAdminLesson(Model model,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("SentencesAdminLesson");
		if(request.getSession().getAttribute("lessonId")!=null)
		 {
	Lesson	lessons = lessonServiceApi.findById((int) request.getSession().getAttribute("lessonId"));
	for(Sentences sentence:lessons.getSentences())
	{
		System.out.println("Sentence Name  ::" +sentence.getSentences());
		model.addAttribute("sentencesList",lessons.getSentences());
		model.addAttribute("sentencesId",sentence.getSentencesId());
	    model.addAttribute("sentencesIsActive",sentence.getSentencesIsActive());

	}
		 }
		return modelAndView;
}
	
	
	@RequestMapping(value="DeactivateSentences", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> DeactivateSentences(@RequestBody Map<String,Object> map )
	{
		Map<String,Object> result = new HashMap<String, Object>();
        Map<String,Object> header = new HashMap<String, Object>();


        if(map.containsKey("sentencesId")) {
            System.out.println("sentencesId:: "+map.get("sentencesId"));
            System.out.println("sentencesIsActive:: "+map.get("isActive"));

            int id=Integer.valueOf((String)map.get("sentencesId"));
            Sentences sentence= sentencesServiceApi.findById((id));

            if (sentence == null) {
            	System.out.println("sentence not found");
                    header.put("message", "sentence doesnot exist");
                    header.put("status",200);
            } else {
            	sentence.setSentencesIsActive((int)map.get("isActive"));
            	sentencesServiceApi.saveOrUpdate(sentence);
                header.put("message", "The requested Sentence is deactivated/activated... Thanks !!");
                header.put("status",404);
            }
        }else{
            header.put("message","please select the Sentence first");
        }

        result.put("header",header);

        return result;
		
	}
	
	
	@RequestMapping(value = "sentences", method=RequestMethod.POST)
    public ModelAndView fileUpload(@RequestParam("image") MultipartFile image,
                                         @RequestParam("audio") MultipartFile audio,
                                         @RequestParam("name") String str , HttpServletRequest request,
                                         @ModelAttribute MediaDomain mediaDomain
    ){

		ModelAndView modelAndView=new ModelAndView("redirect:SentencesAdminLesson");

        if (image!= null && !image.isEmpty()){
            File imageF = new File("C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+image.getOriginalFilename().replace(" ", "-"));
            File audioF = new File("C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/UST-Data/"+audio.getOriginalFilename().replace(" ", "-"));
//            File videoF = new File("C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Desktop/"+video.getOriginalFilename().replace(" ", "-"));

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

                /**Save Video in resource*/
                /*videoF.createNewFile();
                fos = new FileOutputStream(videoF);
                fos.write(video.getBytes());
                fos.close();*/

            }catch(Exception ex){
                System.out.println("ExceptionCaught");
            }
        }else{
        	 System.out.println("In Else");
        }
        
        
        Media media=new Media() ;

        Lesson lesson = new Lesson();
        lesson.setLessonId((int) request.getSession().getAttribute("lessonId"));
      
        mediaDomain.setMediaAudio("static-images/"+audio.getOriginalFilename().replace(" ", "-"));
        media.setMediaAudio(mediaDomain.getMediaAudio());
        mediaDomain.setMediaImage("static-images/"+image.getOriginalFilename().replace(" ", "-"));
        media.setMediaImage(mediaDomain.getMediaImage());
        mediaServiceApi.save(media);
        Sentences sentence=new Sentences();
        sentence.setLesson(lesson);
        sentence.setSentences(str);
        sentence.setMedia(media);
        sentencesServiceApi.save(sentence);
        
        System.out.println("MediaId :: "+media.getMediaId());
       
        
        
        return modelAndView;
    }
	
	@RequestMapping(value = "sentenceEdit",method= RequestMethod.POST)
	public @ResponseBody

    ModelAndView sentenceEdit(@ModelAttribute SentencesDomain sentencesDomain,Model model, HttpServletRequest request ,
    		@RequestParam(value="pic", required = false) MultipartFile file,
    		@RequestParam(value="audio", required = false) MultipartFile files,
    		RedirectAttributes redirectAttributes ) throws ParseException
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/SentencesAdminLesson");
		System.out.println("Test");
	
		
	        
	        if (sentencesDomain.getSentencesName().contains("/")) {
    			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
    			return modelAndView;
    		}
    		if (sentencesDomain.getSentencesName().contains("/")) {
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
    				sentencesDomain.setPicture("static-images/" +"-"+file.getOriginalFilename().replace(" ", "-"));
    				
    				sentencesDomain.setAudiofile("static-images/" +"-"+files.getOriginalFilename().replace(" ", "-"));

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
    		Sentences sentence=sentencesServiceApi.findById(sentencesDomain.getSentencesId());
    		 Media media=mediaServiceApi.findById(sentence.getMedia().getMediaId());

  	        Lesson lesson = new Lesson();
  	        lesson.setLessonId((int) request.getSession().getAttribute("lessonId"));
  			
  	      System.out.println(sentence.getMedia().getMediaId());
  	      System.out.println("Audio " +sentencesDomain.getAudiofile());
  	        System.out.println("Video"+ sentencesDomain.getPicture());
  	        System.out.println("SentenceID :: "+sentence.getSentencesId());
  	        
  	        
  	        media.setMediaAudio(sentencesDomain.getAudiofile());
  	        media.setMediaImage(sentencesDomain.getPicture());
  	        mediaServiceApi.saveOrUpdate(media);
  	      sentence.setLesson(lesson);
  	    sentence.setSentences(sentencesDomain.getSentencesName());
  	  sentence.setMedia(media);
  	        sentencesServiceApi.saveOrUpdate(sentence);
  	        
             
  	        
            
            return modelAndView;
        }
     
	

}

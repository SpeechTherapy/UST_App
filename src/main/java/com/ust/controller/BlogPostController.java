package com.ust.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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

import com.ust.domain.PostDomain;
import com.ust.entity.Post;
import com.ust.entity.Therapist;
import com.ust.service.api.PostServiceApi;
import com.ust.service.api.TherapistServiceApi;

@Controller
@PropertySource({ "classpath:persistence-mysql.properties" })

public class BlogPostController {
	
	@Autowired TherapistServiceApi therapistServiceApi;
	@Autowired PostServiceApi postServiceApi;
	
	@RequestMapping(value="BlogPost")
	public ModelAndView BlogPost(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("BlogPost");

		int userId=(int)request.getSession().getAttribute("userId");
		   int therapistId = (int) request.getSession().getAttribute("loginId");
		         Therapist therapist= therapistServiceApi.findById(therapistId);
		         model.addAttribute("therapistName", therapist.getTherapistName());
					model.addAttribute("CreatedOn", therapist.getCreatedDate());
					model.addAttribute("Email", therapist.getUser().getEmail());
					model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
					model.addAttribute("contactNo", therapist.getTherapistContact());
					model.addAttribute("UserPic", therapist.getUser().getUserPic());
        
        return modelAndView;
    }
	
	@Autowired
    private Environment env;
	@RequestMapping(value = "blog", method = RequestMethod.POST)
	public String blog(@ModelAttribute Post post, Model model ,RedirectAttributes redirectAttributes,
			@ModelAttribute PostDomain postDomain,HttpServletRequest request,
			@RequestParam(value="file", required = false) MultipartFile file) {
		
		int userId=(int)request.getSession().getAttribute("userId");
		   int therapistId = (int) request.getSession().getAttribute("loginId");
		   String imageLocation = null;
   		if (file!=null) {
   			try {
   				imageLocation = env.getProperty("imagePath")+file.getOriginalFilename().replace(" ", "-");
   				BufferedOutputStream stream = new BufferedOutputStream(
   						new FileOutputStream(new File(imageLocation)));
                   FileCopyUtils.copy(file.getInputStream(), stream);
   				stream.close();
   				postDomain.setBlogpic("static-images/"+file.getOriginalFilename().replace(" ", "-"));
   				
   			}
   			catch (Exception e) {
   				System.out.println("Exception caught");
   			}
   		}
   		else {
   			System.out.println("File is Empty");	}
		         Therapist therapist= therapistServiceApi.findById(therapistId);	
		try
		{
		if (post != null)
		{
			System.out.println("Test  Title " + post.getBlogHeading());
			System.out.println("Test  Body " + post.getBlogBody());

		}
		if (!post.getBlogBody().isEmpty() && !post.getBlogHeading().isEmpty()) 
		
		{
	
	        System.out.println("Therrapist ID ::"+therapistId);
	         Therapist therapist1=new Therapist();
	         therapist1.setTherapistId(therapistId);
	         post.setTherapist(therapist1);
	         post.setBlogpic(postDomain.getBlogpic());
	         post.setStatus(1);
	         
		        System.out.println("Therrapist ID Post Domain ::"+post.getTherapist());
postServiceApi.save(post);
			
		}
		
		model.addAttribute("msg","Your Blog has been Uploaded!..Thank you for sharing information.");

		return "redirect:/BlogPost";
	
	}
		 catch(Exception e)
	       {
	       System.out.println("Error");
	       e.printStackTrace();
	       return "redirect:register";
	       }	
		
		

}
	
}

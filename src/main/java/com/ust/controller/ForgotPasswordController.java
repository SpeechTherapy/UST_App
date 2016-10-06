package com.ust.controller;

import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.domain.UserDomain;
import com.ust.entity.User;
import com.ust.mail.Mail;
import com.ust.mail.Mailer;
import com.ust.service.api.UserServiceApi;


@Controller
@RequestMapping(value = "ChangingPassword")
public class ForgotPasswordController
{
	@Autowired 
	private UserServiceApi userServiceApi;
	
	@RequestMapping (value ="newpassword", method = RequestMethod.POST)
	ModelAndView newpassword(@ModelAttribute UserDomain userDomain, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes)
	{
		System.out.println(("user ID"+ userDomain.getUserId()));
		System.out.println("Password"+userDomain.getUserPassword());
		User user = userServiceApi.findById(userDomain.getUserId());
		
		user.setResetPassword(1);
		user.setUserIsActive(1);
		user.setUserPassword(userDomain.getUserPassword());
		
		userServiceApi.saveOrUpdate(user);
		
		redirectAttributes.addFlashAttribute("message", "Enter new Password");
		return new ModelAndView("redirect:/user/LoginUser");
	}
	
	@RequestMapping (value = "newpassword/{object}",method = RequestMethod.GET)
	ModelAndView getnewpassword(@PathVariable("object") String object, Model model, RedirectAttributes redirectAttributes)
	{
		ModelAndView modelAndView = new ModelAndView("LoginUser");
		
		byte decodeUrl[] ={0};

        try {
             decodeUrl  = Base64Utils.decode(object.getBytes());
        }catch (Exception ex){
            ex.printStackTrace();
        }

	
		String decodedStr = new String(decodeUrl);
		if (decodedStr.contains("&&")){

		            String spilter[] = decodedStr.split("&&");

		            if (spilter!=null && spilter.length >= 1){

		            	int userId = Integer.parseInt(spilter[0]);

		                try{

		                    DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
		                    Date result =  df.parse(spilter[1]);

//		                long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;

		                    long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
		                    boolean moreThanDay = Math.abs(result.getTime() - new Date().getTime()) > MILLIS_PER_DAY;


		                    User user = userServiceApi.findById(userId);
		                    if (user!=null && !moreThanDay && user.getResetPassword() !=1){
		                        modelAndView =  new ModelAndView("newpassword");
		                        model.addAttribute("userId", userId);
		                        
		                        return modelAndView;
		                    }else {
		                    	
		                    	redirectAttributes.addFlashAttribute("message" , "password updated");
		                    	modelAndView =  new ModelAndView("LoginUser");
		                    	return modelAndView;
		                    }
		                   
		                }catch (Exception ex)
		                {
		                	ex.printStackTrace();

		                	model.addAttribute("message", "Something went wrong with the password you enter");
		                }
		            
		                }
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "forgotpassword",method= RequestMethod.GET)
	ModelAndView getforgotpassword(Model model)
	{
		return new ModelAndView("forgotpassword");
	}
	
	
	@RequestMapping(value = "forgotpassword",method= RequestMethod.POST)
	ModelAndView forgotpassword(@ModelAttribute User user,Model model, RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("forgotpassword");
		
		user = userServiceApi.findByEmail(user.getEmail());
		
		
		if(user!=null)
		{
	
			   String userAndDate = user.getUserId() + "&&" + new Date();
               byte encodeToUrl[] = {0};

               try 
               {
                   encodeToUrl = Base64Utils.encode(userAndDate.getBytes());
               }
               
               catch (Exception ex)
               {
                   ex.printStackTrace();
               }

               String attach = new String(encodeToUrl);


               Mail mail = new Mail();
               mail.setMailFrom("speechtherapy49@gmail.com");
               mail.setMailTo(user.getEmail());
               mail.setMailSubject("Awaz | Reset Password");
               mail.setTemplateName("Template.vm");

               try
               {
            	   user.setResetPassword(0);
            	   
            	   userServiceApi.update(user);
            	   
                   ApplicationContext context =new ClassPathXmlApplicationContext("email-config.xml");

                   Mailer mailer = (Mailer) context.getBean("mailer");

                   String url = "http://"+request.getServerName()+":"+request.getServerPort()+"/ust/ChangingPassword/newpassword"+"/"+attach;
                   
                   mailer.sendRestPasswordLink(mail, url);
                   
                   //Flash
                   redirectAttributes.addFlashAttribute("message", "Email has been sent to your account please check");
                   
                   
                   modelAndView =new ModelAndView("redirect:/user/LoginUser");

               }
               catch (Exception ex)
               {
            	   ex.printStackTrace();
            	   
            	   model.addAttribute("message", "Some Error occured email not sent");
               }
			
		}else{
			model.addAttribute("message", "There is no account on given email...Please Re-Try");
		}
		return modelAndView;
	}
	
}
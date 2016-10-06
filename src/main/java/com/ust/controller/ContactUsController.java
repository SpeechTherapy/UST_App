package com.ust.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ust.mail.Mail;
import com.ust.mail.Mailer;

@Controller
public class ContactUsController {

	@RequestMapping(value="ContactUs")
	public ModelAndView Contact(Model model){
		ModelAndView modelAndView=new ModelAndView("ContactUs");
		return modelAndView;
	}
 
	@RequestMapping(value="contactUs", method = RequestMethod.GET)
	public  ModelAndView ContactUs(HttpServletRequest request, Model model)
	 {
	   
	 ModelAndView   modelAndView = new ModelAndView("ContactUs");
	 
	        // takes input from e-mail form
	        String emailerName = request.getParameter("name");
	        String email = request.getParameter("email");
	        String message = request.getParameter("message");
	         
	        // prints debug info
	        System.out.println("To: " + emailerName);
	        System.out.println("Subject: " + email);
	        System.out.println("Message: " + message);
	         

            Mail mail = new Mail();
            
        
            mail.setMailTo("speechtherapy49@gmail.com");
            mail.setMailSubject("Kindly Register Me :: "+email);
            mail.setMailContent(message);
            try
            {
         	  
         	   
                ApplicationContext context =new ClassPathXmlApplicationContext("email-config.xml");

                Mailer mailer = (Mailer) context.getBean("mailer");

                mailer.contactUs(mail);
                                
                modelAndView =new ModelAndView("redirect:/ust/ContactUs");

            }
            catch (Exception ex)
            {
         	   ex.printStackTrace();
         	   
         	   model.addAttribute("message", "Some Error occured email not sent");
            }
			
		return modelAndView;
	}
}
	  


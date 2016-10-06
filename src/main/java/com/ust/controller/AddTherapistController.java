package com.ust.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.domain.AdminDomain;
import com.ust.domain.TherapistDomain;
import com.ust.domain.UserDomain;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.mail.Mail;
import com.ust.mail.Mailer;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;


@Controller
public class AddTherapistController {

	@Autowired
	private UserServiceApi userServiceApi;
	
	@Autowired
	private TherapistServiceApi therapistServiceApi;
	
	@RequestMapping(value = "AddTherapist")
	public ModelAndView AddTherapist(Model model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("AddTherapist");
	
		return modelAndView;
	}
	
	@RequestMapping(value = "AddTherapist", method = RequestMethod.POST)
	public String AddTherapist(@ModelAttribute User user, Model model , @ModelAttribute TherapistDomain therapistDomain,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("AddTherapist");

		try
		{
		if (user != null)
		{
			System.out.println("Test  Email " + user.getEmail());
			System.out.println("Test  UserName " + user.getUserName());
			System.out.println("Test  Password " + user.getUserPassword());

		}
		if (!user.getUserName().isEmpty() && !user.getUserPassword().isEmpty()) 
		
		{

            userServiceApi.save(user);
			//therapistDomain.setUserId(user.getUserId());
			System.out.println(user.getUserName());

			
            
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
                   mail.setMailSubject("UST | Congrtaulations! you are registered");
                   mail.setTemplateName("TemplateAdmin.vm");

                   try
                   {
                	   
                	   
                       ApplicationContext context =new ClassPathXmlApplicationContext("email-config.xml");

                       Mailer mailer = (Mailer) context.getBean("mailer");

                       String url = "http://"+request.getServerName()+":"+request.getServerPort()+"/ust/newpasswordTherapist"+"/"+attach;
                       
                       mailer.sendLoginLink(mail, url);
                       
                       //Flash
                       redirectAttributes.addFlashAttribute("msg", "Email has been sent to therapist account please check");
                       
                       
                       modelAndView =new ModelAndView("redirect:/WelcomeAdmin");

                   }
                   catch (Exception ex)
                   {
                	   ex.printStackTrace();
                	   
                	   model.addAttribute("msg", "Some Error occured email not sent");
                   }
    			
    		}
    		else{
    			model.addAttribute("msg", "There is no account on given email...Please Re-Try");
    		}

    		       
		}
		redirectAttributes.addFlashAttribute("css", "success");
		
		  redirectAttributes.addFlashAttribute("msg", "Therapist added successfully!");
	
		return "redirect:AddTherapist";
	
	}
		 catch(Exception e)
	       {
	       System.out.println("Error");
	       e.printStackTrace();
	       redirectAttributes.addFlashAttribute("css", "danger");
		redirectAttributes.addFlashAttribute("msg","Therapist is already Registered! Please username or email");
	       return "redirect:AddTherapist";
	       }	

}
	/*@RequestMapping(value = "SetTherapist", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> SetTherapist(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("therapistId")) {
			System.out.println("therapistId Checking:: " + map.get("therapistId"));
			request.getSession().setAttribute("therapistId", map.get("therapistId"));

		}
		return result;

	}*/
	
	@RequestMapping (value ="newpasswordTherapist", method = RequestMethod.POST)
  ModelAndView newpassword(@ModelAttribute UserDomain userDomain,
			Model model, HttpServletRequest request, RedirectAttributes redirectAttributes)
	{
		System.out.println(("user ID"+ userDomain.getUserId()));
		System.out.println("Password"+userDomain.getUserPassword());
		User user = userServiceApi.findById(userDomain.getUserId());
		
		user.setResetPassword(1);
		user.setUserIsActive(1);
		user.setUserPassword(userDomain.getUserPassword());
		
		request.getSession().setAttribute("userId", userDomain.getUserId());
		
		userServiceApi.saveOrUpdate(user);
				return new ModelAndView("redirect:../ust/therapist/profile");
	}
	@RequestMapping (value = "newpasswordTherapist/{object}",method = RequestMethod.GET)
	ModelAndView getnewpassword(@PathVariable("object") String object, Model model, RedirectAttributes redirectAttributes)
	{
		ModelAndView modelAndView = new ModelAndView("newpasswordTherapist");
		
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
		                        modelAndView =  new ModelAndView("newpasswordTherapist");
		                        model.addAttribute("userId", userId);
		                        
		                        return modelAndView;
		                    }else {
		                    	
		                    	modelAndView =  new ModelAndView("newpasswordTherapist");
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
}

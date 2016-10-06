package com.ust.controller;

import java.util.Collections;
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

import com.ust.domain.TherapistDomain;
import com.ust.domain.UserDomain;
import com.ust.entity.Lesson;
import com.ust.entity.Patient;
import com.ust.entity.Sounds;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;

@Controller
public class DeactivateTherapistController {
	 @Autowired TherapistServiceApi therapistServiceApi;
	 @Autowired 
		 UserServiceApi userServiceApi;

	@RequestMapping(value="TherapistListAdmin" ,method=RequestMethod.GET)
	public ModelAndView DeactivateTherapist(Model model,HttpServletRequest request)
	{
		ModelAndView modelAndView=new ModelAndView("TherapistListAdmin");
	
		List<Therapist> therapistList = therapistServiceApi.findTherapist();
		System.out.println("Therapist Name ::"+therapistList.size());
		
		if(therapistList.size()>0)
		{
			for(Therapist therapist:therapistList ){
			System.out.println("Name :: "+therapist.getTherapistName());
		    model.addAttribute("therapistList",therapistList);
		    model.addAttribute("therapistId",therapist.getTherapistId());
			model.addAttribute("createdDate",therapist.getCreatedDate());
			model.addAttribute("user.userIsActive",therapist.getUser().getUserIsActive());
			model.addAttribute("therapistName", therapist.getTherapistName());
			//model.addAttribute("email", therapist.getUser().getEmail());
			//model.addAttribute("hospital", therapist.getHospital().getHospitalName());
			//model.addAttribute("therapistContact", therapist.getTherapistContact());
			//model.addAttribute("UserPic", therapist.getUser().getUserPic());

			System.out.println("Status"+therapist.getUser().getUserIsActive());
			System.out.println("Created on ::"+therapist.getCreatedDate());
			System.out.println("User ID:: "+therapist.getUser().getUserId());
			
			}
			 
		return modelAndView;
		
	}
		return modelAndView;
	}
	
	@RequestMapping(value="Deactivate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> Deactivate(@RequestBody Map<String,Object> map)
	{
		Map<String,Object> result = new HashMap<String, Object>();
        Map<String,Object> header = new HashMap<String, Object>();


        if(map.containsKey("therapistId")) {
            System.out.println("TherapistId:: "+map.get("therapistId"));

            int id=Integer.valueOf((String)map.get("therapistId"));
            Therapist therapist= therapistServiceApi.findById((id));
			System.out.println("UserID through therapist::"+therapist.getUser().getUserId());

            if (therapist == null) {
            	System.out.println("UserName not found");
                    header.put("message", "Username doesnot exist");
                    header.put("status",200);
            } else {
            	System.out.println("UserName"+therapist.getTherapistName());
            	User user= therapist.getUser();
            	user.setUserIsActive((int)map.get("isActive"));
            	userServiceApi.saveOrUpdate(user);
                header.put("message", "The requested id is activated/deactivated... Thanks !!");
                header.put("status",404);
            }
        }else{
            header.put("message","please select the thearpist first");
        }

        result.put("header",header);

        return result;
		
	}
	
	@RequestMapping(value = "Therapist", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> Therapist(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("therapistId")) {
			System.out.println("therapistId Checkinggggg:: " + map.get("therapistId"));
			request.getSession().setAttribute("therapistId", map.get("therapistId"));

		}

		return result;

	}
	
	

}

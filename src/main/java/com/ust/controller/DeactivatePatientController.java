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

import com.ust.domain.UserDomain;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.UserServiceApi;

@Controller
public class DeactivatePatientController {

	 @Autowired 
		private UserServiceApi userServiceApi;
	 @Autowired
	 private PatientserviceApi patientServiceApi;
	 
	 @RequestMapping(value="PatientListAdmin" ,method=RequestMethod.GET)
		public ModelAndView DeactivatePatient(Model model,HttpServletRequest request)
		{
			ModelAndView modelAndView=new ModelAndView("PatientListAdmin");
			

			List<Patient> patientList = patientServiceApi.findAll();

			System.out.println("patient Name ::"+patientList.size());

			if(patientList.size()>0)
			{
				for(Patient patient:patientList){
				System.out.println("Name :: "+patient.getPatientName());			
			    model.addAttribute("patientList",patientList);
			    model.addAttribute("patientName",patient.getPatientName());
				model.addAttribute("createdDate",patient.getCreatedDate());
				model.addAttribute("user.userIsActive",patient.getUser().getUserIsActive());
				System.out.println("Status"+patient.getUser().getUserIsActive());
				System.out.println("Created on ::"+patient.getCreatedDate());
				System.out.println("User ID:: "+patient.getUser().getUserId());
			
				
				}
			    
			return modelAndView;
			
		}
			return modelAndView;
		}
		
	 @RequestMapping(value="DeactivateButton", method=RequestMethod.POST)
		public @ResponseBody Map<String,Object> Deactivate(@RequestBody Map<String,Object> map)
		{
			Map<String,Object> result = new HashMap<String, Object>();
	        Map<String,Object> header = new HashMap<String, Object>();


	        if(map.containsKey("patientId")) {
	            System.out.println("TherapistId:: "+map.get("patientId"));
	            System.out.println("TherapistIsActive:: "+map.get("isActive"));


	            int id=Integer.valueOf((String)map.get("patientId"));
	            Patient patient= patientServiceApi.findById((id));
				System.out.println("UserID through patient::"+patient.getUser().getUserId());

	            if (patient == null) {
	            	System.out.println("UserName not found");
	                    header.put("message", "Username doesnot exist");
	                    header.put("status",200);
	            } else {
	            	User user= patient.getUser();
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
	 
	 @RequestMapping(value = "Patient", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> Patient(@RequestBody Map<String, Object> map,
				HttpServletRequest request) {
			Map<String, Object> result = new HashMap<String, Object>();
			Map<String, Object> header = new HashMap<String, Object>();

			if (map.containsKey("patientId")) {
				System.out.println("patientId Checkinggggg:: " + map.get("patientId"));
				request.getSession().setAttribute("patientId", map.get("patientId"));

			}

			return result;

		}
		
		
		
}

package com.ust.controller;


import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.domain.PatientDomain;
import com.ust.domain.ReportDomain;
import com.ust.entity.City;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.UserServiceApi;


@Controller
public class  PatientController
{
	
@Autowired PatientserviceApi patientserviceApi;
	
	@Autowired UserServiceApi userserviceApi;
	@Autowired PatientserviceApi patientServiceApi;

@RequestMapping(value = "Patientprofile")
public ModelAndView Patientprofile(HttpServletRequest request,Model model , RedirectAttributes redirectattributes) {
  ModelAndView modelAndView = new ModelAndView("Patientprofile");

		
		return modelAndView;
    
	}
	
	
@RequestMapping(value = "Patientprofile",method= RequestMethod.POST)
public @ResponseBody

ModelAndView Profile(@ModelAttribute PatientDomain patientDomain,Model model, HttpServletRequest request ,Patient patient,
		@RequestParam(value="file", required = false) MultipartFile file, RedirectAttributes redirectAttributes ) throws ParseException
{
	ModelAndView modelAndView;
					modelAndView = new ModelAndView("Profile");
			
			DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
	        
	        Date date = df.parse(df.format(new Date()));
	       

    		String imageLocation = null;
    		if (file!=null) {
    			try {
    				imageLocation = "C:/Users/Sana/Desktop/ustdata/"  +"-"+file.getOriginalFilename().replace(" ", "-");
    				BufferedOutputStream stream = new BufferedOutputStream(
    						new FileOutputStream(new File(imageLocation)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
    				stream.close();
    				patientDomain.setPic("static-images/" +"-"+file.getOriginalFilename().replace(" ", "-"));
    				redirectAttributes.addFlashAttribute("message",
    						"You successfully uploaded " + patientDomain.getPatientName() + "!");
    			}
    			catch (Exception e) {
    				redirectAttributes.addFlashAttribute("message",
    						"You failed to upload " + patientDomain.getPatientName() + " => " + e.getMessage());
    			}
    		}
    		else {
    			redirectAttributes.addFlashAttribute("message",
    					"You failed to upload " + patientDomain.getPatientName() + " because the file was empty");
    		}
    		
    		User user = userserviceApi.findById((int) request.getSession().getAttribute("patientId"));

        	user.setUserPic(patientDomain.getPic());
        	
        	userserviceApi.update(user);
        	
            System.out.println(request.getSession().getAttribute("loginId"));
	
            patient = patientserviceApi .findById((int)( request.getSession().getAttribute("PatientID")));

            patient.setPatientName(patientDomain.getPatientName());
            patient.setContactNum(patientDomain.getContactNum());
            patient.setAllergies(patientDomain.getAllergies());    
            patient.setLanguageSpoken(patientDomain.getLanguageSpoken());  
            patient.setContactNum(patientDomain.getContactNum());
            patient.setPatientGuardianName(patientDomain.getGuradianName());
            patient.setPatientAge(patientDomain.getPatientAge());
            patient.setPatientGender(patientDomain.getPatientGender());

            patient.setUser(user);
            
            patientserviceApi.update(patient);
            request.getSession().setAttribute("loginId",patient.getPatientId());
            request.getSession().setAttribute("userId",user.getUserId());


            redirectAttributes.addFlashAttribute("message","Profile Updated Successfully");
            modelAndView = new ModelAndView("redirect:/user/WelcomePatient");
            
            return modelAndView;

		}
       
        //Successfully 




//EditPatientProfile Controller

@RequestMapping(value = "PatientProfileEdit")
public ModelAndView PatientProfileEdit(HttpServletRequest request,Model model , RedirectAttributes redirectattributes) {
  ModelAndView modelAndView=new ModelAndView("PatientProfileEdit");
		
  if(request.getSession().getAttribute("loginId")!=null)

	{
		Patient patient = patientServiceApi.findById((int)request.getSession().getAttribute("loginId"));

	        	model.addAttribute("userPic", patient.getUser().getUserPic());
				System.out.println("Patient Pic :: "+patient.getUser().getUserPic());
				System.out.println("Patient :: "+patient.getPatientId());
				model.addAttribute("patientName", patient.getPatientName());
				System.out.println("Patient Name :: "+patient.getPatientName());
				model.addAttribute("languageSpoken", patient.getLanguageSpoken());
				System.out.println("Language spoken :: "+patient.getLanguageSpoken());
				model.addAttribute("allergies", patient.getAllergies());
				model.addAttribute("guradianName",patient.getPatientGuardianName());
				model.addAttribute("patientAge", patient.getPatientAge());
				
				
				model.addAttribute("contactNumber", patient.getContactNum());
				System.out.println("Contact :: "+patient.getContactNum());
			
	}
	else{
		System.out.println("Nothing To Display");
	       return modelAndView;
	}
return modelAndView;
	}

@RequestMapping(value = "PatientProfileEdit",method= RequestMethod.POST)
public @ResponseBody

ModelAndView PatientProfileEdit(@ModelAttribute PatientDomain patientDomain,Model model, HttpServletRequest request ,Patient patient,
		@RequestParam(value="file", required = false) MultipartFile file, RedirectAttributes redirectAttributes ) throws ParseException
{
	ModelAndView modelAndView;
	modelAndView = new ModelAndView("Profile");

		if( request.getSession().getAttribute("loginId")!=null)
		
		{
			int userId = (int)request.getSession().getAttribute("loginId");

			
			DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
	        
	        Date date = df.parse(df.format(new Date()));
	       

	        String imageLocation = null;
    		if (file!=null) {
    			try {
    				imageLocation = "C:/Users/Sana/Desktop/ustdata/" +file.getOriginalFilename().replace(" ", "-");
    				BufferedOutputStream stream = new BufferedOutputStream(
    						new FileOutputStream(new File(imageLocation)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
    				stream.close();
    				patientDomain.setPic("static-images/" +file.getOriginalFilename().replace(" ", "-"));
    				redirectAttributes.addFlashAttribute("message",
    						"You successfully uploaded " + patientDomain.getPatientName() + "!");
    			}
    			catch (Exception e) {
    				redirectAttributes.addFlashAttribute("message",
    						"You failed to upload " + patientDomain.getPatientName() + " => " + e.getMessage());
    			}
    		}
    		else {
    			redirectAttributes.addFlashAttribute("message",
    					"You failed to upload " + patientDomain.getPatientName() + " because the file was empty");
    		}
    		User user = userserviceApi.findById(userId);
    		
    		System.out.println("User Pic"+patientDomain.getPic());
        	user.setUserPic(patientDomain.getPic());
        	
        	user.setUserPic(patientDomain.getPic());
        	
        	userserviceApi.saveOrUpdate(user);
        	
            System.out.println(request.getSession().getAttribute("loginId"));
	
            patient = patientserviceApi .findById((int)( request.getSession().getAttribute("PatientID")));

            patient.setPatientName(patientDomain.getPatientName());
            patient.setContactNum(patientDomain.getContactNum());
            patient.setAllergies(patientDomain.getAllergies());    
            patient.setLanguageSpoken(patientDomain.getLanguageSpoken());  
            patient.setContactNum(patientDomain.getContactNum());
            patient.setPatientGuardianName(patientDomain.getGuradianName());
            patient.setPatientAge(patientDomain.getPatientAge());
            patient.setPatientGender(patientDomain.getPatientGender());

            patient.setUser(user);
            
            patientserviceApi.saveOrUpdate(patient);
            request.getSession().setAttribute("loginId",patient.getPatientId());
            request.getSession().setAttribute("userId",user.getUserId());


            redirectAttributes.addFlashAttribute("message","Profile Updated Successfully");
            modelAndView = new ModelAndView("redirect:/user/WelcomePatient");
            
            return modelAndView;
		}
		return modelAndView;
		}

        
}
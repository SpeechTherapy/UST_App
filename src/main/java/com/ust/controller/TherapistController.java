package com.ust.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ust.domain.TherapistDomain;
import com.ust.entity.City;
import com.ust.entity.Hospital;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.CityServiceApi;
import com.ust.service.api.HospitalServiceApi;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;

@Controller
@PropertySource({ "classpath:persistence-mysql.properties" })
@RequestMapping(value="therapist")
public class TherapistController { 

	@Autowired
	private UserServiceApi userServiceApi;
	
	@Autowired
    private Environment env;
	
	@Autowired
	private HospitalServiceApi hospitalServiceApi;
	
	@Autowired
	private CityServiceApi cityServiceApi;
	
	
	@Autowired
	private TherapistServiceApi therapistServiceApi;
	
	@RequestMapping(value = "profile")
	 public ModelAndView Profile(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes
			,@ModelAttribute User user,@ModelAttribute TherapistDomain therapistDomain) {
	ModelAndView	modelAndView = new ModelAndView("Profile");
	List<City> cityList = cityServiceApi.findAll();
			List<Hospital> hospitalList = hospitalServiceApi.findAll();
			model.addAttribute("cityList",cityList);
			model.addAttribute("hospitalList",hospitalList);

		
		return modelAndView;
    
	}
	
	
	
	@RequestMapping(value = "profile",method= RequestMethod.POST)
	public @ResponseBody

    ModelAndView Profile(@ModelAttribute TherapistDomain therapistDomain, HttpServletRequest request ,
    		@RequestParam(value="file", required = false) MultipartFile file, RedirectAttributes redirectAttributes ) 
    				throws ParseException
	{
		ModelAndView modelAndView;
		int userId = (int)request.getSession().getAttribute("userId");
			modelAndView = new ModelAndView("Profile");
			
			DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
	        
	        Date date = df.parse(df.format(new Date()));
	       

    		String imageLocation = null;
    		if (file!=null) {
    			try {
    				imageLocation = env.getProperty("imagePath") +"-"+file.getOriginalFilename().replace(" ", "-");
    				BufferedOutputStream stream = new BufferedOutputStream(
    						new FileOutputStream(new File(imageLocation)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
    				stream.close();
    				therapistDomain.setPicture("static-images/" +"-"+file.getOriginalFilename().replace(" ", "-"));
    				redirectAttributes.addFlashAttribute("message",
    						"You successfully uploaded " + therapistDomain.getName() + "!");
    			}
    			catch (Exception e) {
    				redirectAttributes.addFlashAttribute("message",
    						"You failed to upload " + therapistDomain.getName() + " => " + e.getMessage());
    			}
    		}
    		else {
    			redirectAttributes.addFlashAttribute("message",
    					"You failed to upload " + therapistDomain.getName() + " because the file was empty");
    		}
    		User user = userServiceApi.findById(userId);
    		System.out.println("User Pic"+therapistDomain.getPicture());
        	user.setUserPic(therapistDomain.getPicture());
        	
        	userServiceApi.update(user);
        	
            City city = new City();
            city.setCityId(therapistDomain.getCityId());
            System.out.println("User Pic"+therapistDomain.getCityId());

            	
            Hospital hospital = new Hospital();
            	
            hospital.setCity(city);
            hospital.setHospitalName(therapistDomain.getHospitalName());
            hospital.setHospitalAddress(therapistDomain.getHospAddress());
            	
            int hospitalId = hospitalServiceApi.save(hospital);
            
            hospital.setHospitalId(hospitalId);
    		Therapist therapist = new Therapist();

            
            therapist.setCreatedDate(date);
            therapist.setHospital(hospital);
            therapist.setTherapistContact(therapistDomain.getContactNumber());
            therapist.setTherapistGender(therapistDomain.getTherapistGender());
            therapist.setTherapistName(therapistDomain.getName());
            therapist.setUser(user);
            
            therapistServiceApi.saveOrUpdate(therapist);
            System.out.println("Therapist Id"+therapist.getTherapistId());
            request.getSession().setAttribute("loginId",therapist.getTherapistId());
            redirectAttributes.addFlashAttribute("message","Profile Updated Successfully");
            modelAndView = new ModelAndView("redirect:/user/WelcomeTherapist");
		
        return modelAndView;//Successfully 
        }
	
	//Edit Therapist Profile
	
	@RequestMapping(value = "EditProfileTherapist")
	 public ModelAndView EditProfileTherapist(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes
			,@ModelAttribute User user,@ModelAttribute TherapistDomain therapistDomain) {
	ModelAndView	modelAndView = new ModelAndView("EditProfileTherapist");
	if(request.getSession().getAttribute("loginId")!=null)

	{
		Therapist therapist = therapistServiceApi.findById((int)request.getSession().getAttribute("loginId"));

	        	model.addAttribute("userPic", therapist.getUser().getUserPic());
				System.out.println("Therapist Pic :: "+therapist.getUser().getUserPic());
				System.out.println("Therapist :: "+therapist.getTherapistId());
				model.addAttribute("therapistName", therapist.getTherapistName());
				System.out.println("Therapist Name :: "+therapist.getTherapistName());
				model.addAttribute("hospitalName", therapist.getHospital().getHospitalName());
				System.out.println("Therapist Hospital :: "+therapist.getHospital().getHospitalName());
				model.addAttribute("hospitalAddress", therapist.getHospital().getHospitalAddress());
				System.out.println("Therapist Hospital Address :: "+therapist.getHospital().getHospitalAddress());
				model.addAttribute("cityName", therapist.getHospital().getCity().getCityName());
				System.out.println("Therapist City :: "+therapist.getHospital().getCity().getCityName());
				System.out.println("Therapist Gender :: "+therapist.getTherapistGender());
				model.addAttribute("contact", therapist.getTherapistContact());
				System.out.println("Therapist Contact :: "+therapist.getTherapistContact());
			
		
		List<City> cityList = cityServiceApi.findAll();
		List<Hospital> hospitalList = hospitalServiceApi.findAll();
		model.addAttribute("cityList",cityList);
		model.addAttribute("hospitalList",hospitalList);
	}
	else{
		System.out.println("Error");
	}
		
		return modelAndView;
   
	}
	
	@RequestMapping(value = "Editprofile",method= RequestMethod.POST)
	public @ResponseBody

    ModelAndView Editprofile(@ModelAttribute TherapistDomain therapistDomain, HttpServletRequest request ,
    		@RequestParam(value="file", required = false) MultipartFile file, RedirectAttributes redirectAttributes ) 
    				throws ParseException
	{
		ModelAndView modelAndView=new ModelAndView("Profile");;
		int userId = (int)request.getSession().getAttribute("userId");
		int therapistId=(int) request.getSession().getAttribute("therapistId");
		if( request.getSession().getAttribute("loginId")!=null)
		{
			modelAndView = new ModelAndView("Profile");
			
			DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
	        
	        Date date = df.parse(df.format(new Date()));
	       

    		String imageLocation = null;
    		if (file!=null) {
    			try {
    				imageLocation = env.getProperty("imagePath")+file.getOriginalFilename().replace(" ", "-");
    				BufferedOutputStream stream = new BufferedOutputStream(
    						new FileOutputStream(new File(imageLocation)));
                    FileCopyUtils.copy(file.getInputStream(), stream);
    				stream.close();
    				therapistDomain.setPicture("static-images/"+file.getOriginalFilename().replace(" ", "-"));
    				redirectAttributes.addFlashAttribute("message",
    						"You successfully uploaded " + therapistDomain.getName() + "!");
    			}
    			catch (Exception e) {
    				redirectAttributes.addFlashAttribute("message",
    						"You failed to upload " + therapistDomain.getName() + " => " + e.getMessage());
    			}
    		}
    		else {
    			redirectAttributes.addFlashAttribute("message",
    					"You failed to upload " + therapistDomain.getName() + " because the file was empty");
    		}
    		User user = userServiceApi.findById(userId);
    		System.out.println("User Pic"+therapistDomain.getPicture());
        	user.setUserPic(therapistDomain.getPicture());
        	
        	userServiceApi.saveOrUpdate(user);
        	
            City city = new City();
            city.setCityId(therapistDomain.getCityId());
            System.out.println("User Pic"+therapistDomain.getCityId());

            	
            Hospital hospital = new Hospital();
            	
            hospital.setCity(city);
            hospital.setHospitalName(therapistDomain.getHospitalName());
            hospital.setHospitalAddress(therapistDomain.getHospAddress());
            	
            int hospitalId = hospitalServiceApi.save(hospital);
            
            hospital.setHospitalId(hospitalId);
    		Therapist therapist = therapistServiceApi.findById((int)( request.getSession().getAttribute("loginId")));

            
            therapist.setCreatedDate(date);
            therapist.setHospital(hospital);
            therapist.setTherapistContact(therapistDomain.getContactNumber());
            therapist.setTherapistGender(therapistDomain.getTherapistGender());
            therapist.setTherapistName(therapistDomain.getName());
            therapist.setUser(user);
            
            therapistServiceApi.saveOrUpdate(therapist);
            
            redirectAttributes.addFlashAttribute("message","Profile Updated Successfully");
            modelAndView = new ModelAndView("redirect:/user/WelcomeTherapist");
            
            return modelAndView;

		}
		else{
			System.out.println("Error");
		}
       
        return modelAndView;//Successfully 
        }
	
	
}
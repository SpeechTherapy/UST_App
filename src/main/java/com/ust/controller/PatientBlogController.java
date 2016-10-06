package com.ust.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.entity.Lesson;
import com.ust.entity.Patient;
import com.ust.entity.Post;
import com.ust.entity.Therapist;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.PostServiceApi;
import com.ust.service.api.TherapistServiceApi;


@Controller
public class PatientBlogController {
	
	@Autowired
	PatientserviceApi patientServiceApi;
	@Autowired
	PostServiceApi postServiceApi;
	

	@RequestMapping(value = "PatientBlog")
	public ModelAndView Lessons(Model model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("PatientBlog");
		int userId = (int) request.getSession().getAttribute("userId");
		int patientId = (int) request.getSession().getAttribute("loginId");
		Patient patient = patientServiceApi.findById(patientId);
		if (request.getSession().getAttribute("userId") != null) {
			if (patient != null) {
				System.out.println("Patient Name ::" + patient.getCreatedDate());
				model.addAttribute("patientName", patient.getPatientName());
				model.addAttribute("createdOn", patient.getCreatedDate());
				model.addAttribute("email", patient.getUser().getEmail());
				model.addAttribute("contactNo", patient.getContactNum());
				model.addAttribute("userPic", patient.getUser().getUserPic());
				model.addAttribute("guradianName", patient.getPatientGuardianName());
				
				model.addAttribute("therapistName", patient.getTherapist().getTherapistName());
				model.addAttribute("CreatedOn", patient.getTherapist().getCreatedDate());
				model.addAttribute("Email", patient.getTherapist().getUser().getEmail());
				model.addAttribute("Hospital", patient.getTherapist().getHospital().getHospitalName());
				model.addAttribute("contactNo", patient.getTherapist().getTherapistContact());
				model.addAttribute("UserPic", patient.getTherapist().getUser().getUserPic());

			}
		}
		List<Post> postList = postServiceApi.findAll();

		System.out.println(" Post List::" + postList.size());

		if (postList.size() > 0) {
			model.addAttribute("postList", postList);

			for (Post post : postList) {
				if(post.getStatus()>0){
					model.addAttribute("therapist", post.getTherapist().getTherapistName());
				//	model.addAttribute("userPic", post.getTherapist().getUser().getUserPic());
					model.addAttribute("blogpic", post.getBlogpic());
					model.addAttribute("blogBody", post.getBlogBody());
					model.addAttribute("blogHeading", post.getBlogHeading());
					model.addAttribute("status",post.getStatus());
					
				System.out.println("Blog Heading :: "+post.getBlogHeading() +" Blog Status :: "+post.getStatus());
				System.out.println("Post Body :: "+post.getBlogBody());
		System.out.println("Therapist Name :: "+post.getTherapist().getTherapistName());
				}
			}
		}

		return modelAndView;
	}

}

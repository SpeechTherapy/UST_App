package com.ust.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.domain.LessonDomain;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Lesson;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.AssignedChapterTherapistServiceApi;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.PatientserviceApi;

@Controller
public class PatientLessonController
{
	@Autowired LessonServiceApi lessonServiceApi;
	@Autowired AssignedChapterTherapistServiceApi assignedChapterTherapistServiceApi;
	@Autowired PatientserviceApi patientServiceApi;
	
	@RequestMapping (value = "LessonsPatient")

	 public ModelAndView LessonsPatient(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, @ModelAttribute User user)
	 {
		
		
		ModelAndView modelAndView = new ModelAndView("LessonsPatient");
		   int userId=(int)request.getSession().getAttribute("userId");
		   int patientId = (int) request.getSession().getAttribute("loginId");
			Patient patient = patientServiceApi.findById(patientId);

		   if(request.getSession().getAttribute("userId")!=null)
		   {
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
		    System.out.println("PAtient Lesson Controller"+patientId);
		    List<Lesson> lessonList= lessonServiceApi.findAll();

			System.out.println(" Lesson List::"+lessonList.size());

			if(lessonList.size()>0)
			{
				/*model.addAttribute("lessonList",lessonList);

				for(Lesson lesson:lessonList)
				{


				}*/
				System.out.println("Testing");
				
				LessonDomain lessonDomain=new LessonDomain();
                model.addAttribute("AssignedChapter",patient.getAssignedchapterTherapist());
				for(AssignedChapterTherapist assignedChapterTherapist : patient.getAssignedchapterTherapist())
		        {

				lessonDomain.setAssignedChapterTherapist(assignedChapterTherapist.getAssignedChapterId());
				System.out.println("Assigned Lesson:: "+assignedChapterTherapist.getLesson().getLesson() );
				System.out.println("Lesson Domain :: "+lessonDomain.getAssignedChapterTherapist());
				System.out.println("Assigned Chapter Lesson ID :: "+assignedChapterTherapist.getAssignedChapterId());
				System.out.println("Status :: "+assignedChapterTherapist.getStatus() );
				/*model.addAttribute("status", assignedChapterTherapist.getStatus() );
				model.addAttribute("lessonId",assignedChapterTherapist.getLesson().getLessonId());*/
				
				System.out.println("Lesson ID VIA Assign Chapter :: "+assignedChapterTherapist.getLesson().getLessonId());
				
		        }
				
				
			}
		  return modelAndView;
		   }
		   else{
		    redirectAttributes.addFlashAttribute("message", "Session has been expired please 'Login' Again");
		    modelAndView = new ModelAndView("redirect:/user/LoginUser");
		   }
		   return modelAndView;
		   
}
}

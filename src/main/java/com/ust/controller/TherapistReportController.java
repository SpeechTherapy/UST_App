package com.ust.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.domain.ReportDomain;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Hospital;
import com.ust.entity.Patient;
import com.ust.entity.PatientProgressSentences;
import com.ust.entity.PatientProgressSound;
import com.ust.entity.PatientsProgressWord;
import com.ust.entity.Records;
import com.ust.entity.Therapist;
import com.ust.service.api.AssignedChapterTherapistServiceApi;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;

@Controller
public class TherapistReportController {
	
	@Autowired UserServiceApi userServiceApi;
	 @Autowired TherapistServiceApi therapistServiceApi;
	 @Autowired PatientserviceApi patientServiceApi;
	 @Autowired AssignedChapterTherapistServiceApi assignedChapterServiceApi;
	 
	 @RequestMapping(value="List", method=RequestMethod.GET)
	 public @ResponseBody
	 ModelAndView List(Model model , HttpServletRequest request , RedirectAttributes redirectAttributes) throws ParseException
	 {
		 ModelAndView modelAndView = new ModelAndView("List");
		 int userId = (int) request.getSession().getAttribute("userId");
			int therapistId = (int) request.getSession().getAttribute("loginId");
			Therapist therapist = therapistServiceApi.Report(therapistId);
			if (request.getSession().getAttribute("userId") != null) {
				if (therapist != null) {
					System.out.println("Therapist Name ::" + therapist.getTherapistName());
					model.addAttribute("therapistName", therapist.getTherapistName());
					model.addAttribute("CreatedOn", therapist.getCreatedDate());
					model.addAttribute("Email", therapist.getUser().getEmail());
					model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
					model.addAttribute("contactNo", therapist.getTherapistContact());
					model.addAttribute("UserPic", therapist.getUser().getUserPic());
List<Patient> patientList=patientServiceApi.findAll();
				 for(Patient patient:patientList)
		            {
					 model.addAttribute("Pic", patient.getUser().getUserPic());
					 model.addAttribute("patientList",therapist.getPatient());
         			model.addAttribute("patientName", patient.getPatientName());
         			model.addAttribute("patientAge",patient.getPatientAge());
         			model.addAttribute("patientGender", patient.getPatientGender());
         			

            		System.out.println("Patient Name  ::" +patient.getPatientName());
        			List<AssignedChapterTherapist> assignedChapterList= assignedChapterServiceApi.findAll();
        			for(AssignedChapterTherapist assignedChapterTherapist : patient.getAssignedchapterTherapist()){
        				System.out.println("Testing");
        				System.out.println("Patient Name"+patient.getPatientName());
        				System.out.println("Assigned Lesson Id :: "+assignedChapterTherapist.getAssignedChapterId());
        				
        			}

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
	
	 @RequestMapping(value = "SetPatientId", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> SetLessonId(@RequestBody Map<String, Object> map,
				HttpServletRequest request) {
			Map<String, Object> result = new HashMap<String, Object>();
			Map<String, Object> header = new HashMap<String, Object>();

			if (map.containsKey("patientId")) {
				System.out.println("patientId Checkinggggg:: " + map.get("patientId"));
				request.getSession().setAttribute("patientId", map.get("patientId"));

			}

			return result;

		}
	 
	 @RequestMapping(value = "SetAssignedId", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> SetAssignedId(@RequestBody Map<String, Object> map,
				HttpServletRequest request) {
			Map<String, Object> result = new HashMap<String, Object>();
			Map<String, Object> header = new HashMap<String, Object>();

			if (map.containsKey("assignedId")) {
				System.out.println("assignedId Checkinggggg:: " + map.get("assignedId"));
				request.getSession().setAttribute("assignedId", map.get("assignedId"));
	  			System.out.println("assignedId :: "+ request.getSession().getAttribute("assignedId") );


			}

			return result;

		}
	 @RequestMapping(value = "Treport",method= RequestMethod.GET)
	    public @ResponseBody


	ModelAndView TherapistReport(Model model, HttpServletRequest request , RedirectAttributes redirectAttributes
	   ) throws ParseException
	{
	 
	       ModelAndView modelAndView = new ModelAndView("Treport");
	       int userId = (int)request.getSession().getAttribute("userId");
	       if(request.getSession().getAttribute("userId") != null)
	       {
	       modelAndView = new ModelAndView("Treport");
	          System.out.println("User Id "+userId);
	          System.out.println("Therapist ID "+request.getSession().getAttribute("loginId"));
	    int therapistId = (int) request.getSession().getAttribute("loginId");
	    Therapist therapist = therapistServiceApi.findById(therapistId);
	    if (request.getSession().getAttribute("userId") != null) {
	     if (therapist != null) {
	      System.out.println("Therapist Name ::" + therapist.getTherapistName());
	      model.addAttribute("therapistName", therapist.getTherapistName());
	      model.addAttribute("CreatedOn", therapist.getCreatedDate());
	      model.addAttribute("Email", therapist.getUser().getEmail());
	      model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
	      model.addAttribute("contactNo", therapist.getTherapistContact());
	      model.addAttribute("UserPic", therapist.getUser().getUserPic());
	     }
	           ReportDomain reportDomain =new ReportDomain();
	        //    int id=Integer.valueOf((String)request.getSession().getAttribute("patientId"));

	            Patient patient= patientServiceApi.findById((int)request.getSession().getAttribute("patientId"));

	           
	              reportDomain.setPatientName(patient.getPatientName());
	                 reportDomain.setAge(patient.getPatientAge());
	                 reportDomain.setAllergies(patient.getAllergies());
	                 reportDomain.setContactNum(patient.getContactNum());
	                 reportDomain.setdOB(patient.getPatientDob());
	                 reportDomain.setGuardianName(patient.getPatientGuardianName());
	                 reportDomain.setDate(patient.getCreatedDate());
	                 reportDomain.setGender(patient.getPatientGender());
	                 reportDomain.setLanguage(patient.getLanguageSpoken());
	                 reportDomain.setDate(patient.getCreatedDate());
	                 
	              model.addAttribute("guardianName",reportDomain.getGuardianName());
	               model.addAttribute("age",reportDomain.getAge());
	               model.addAttribute("gender",reportDomain.getGender());
	               model.addAttribute("date",reportDomain.getDate());
	               model.addAttribute("patientName",reportDomain.getPatientName());
	               model.addAttribute("dOB",reportDomain.getdOB());
	               model.addAttribute("contactNum",reportDomain.getContactNum());
	               model.addAttribute("language",reportDomain.getLanguage());
	               model.addAttribute("Allergies",reportDomain.getAllergies());
	             
	               System.out.println("Patient Name" +patient.getPatientName());
	             
	             for(AssignedChapterTherapist assignedChapterTherapist : patient.getAssignedchapterTherapist())
	                {
	              reportDomain.setLesson(assignedChapterTherapist.getLesson().getLesson());
	              model.addAttribute("lesson",reportDomain.getLesson());
	                 System.out.println("*******************************");
	                 System.out.println("LessonId  "+assignedChapterTherapist.getLesson().getLessonId());
	                 System.out.println("LessonName "+assignedChapterTherapist.getLesson().getLesson());
	                 System.out.println("Assigned Chap Id :: "+assignedChapterTherapist.getAssignedChapterId());
	                 
	                 for(PatientProgressSentences patientProgressSentences : assignedChapterTherapist.getPatientProgressSentences())
	                 {
	                  
	                  reportDomain.setPatientProgressSentences(patientProgressSentences.getPatientProgressSentences());
	                  model.addAttribute("Patientprogresssentence",reportDomain.getPatientProgressSentences());
	                  System.out.println("Sentences Remarks "+patientProgressSentences.getPatientProgressSentences());
	                     System.out.println("*******************************");
	                  System.out.println("Sentence Id :: "+patientProgressSentences.getPatientProgressSentencesId());
	                 }
	                 
	                 for(PatientProgressSound patientProgressSound : assignedChapterTherapist.getPatientProgressSound())
	                 { 
	                  reportDomain.setPatientProgressSound(patientProgressSound.getPatientProgressSound());
	                  model.addAttribute("patientProgressSound",reportDomain.getPatientProgressSound());
	                  System.out.println("Sounds Remarks :: "+patientProgressSound .getPatientProgressSound());
	                 }
	                 for(PatientsProgressWord patientsProgressWord : assignedChapterTherapist.getPatientsProgressWord())
	                 {
	                  reportDomain.setPatientProgressWord(patientsProgressWord.getPatientsprogress());
	                  model.addAttribute("patientProgressWord",reportDomain.getPatientProgressWord());
	                  System.out.println("Word" + patientsProgressWord.getPatientsprogressId());
	                 }
	                 
	                 
	                }
	                
	                for(Records recordedAudio: patient.getRecordedAudio())
	                {

	                 System.out.println("RecordedAudios "+recordedAudio.getRecordedAudioId());
	                }
	            }


	          }
	           
	          
	 return modelAndView;
	    
	}
	 
	 
	/*@RequestMapping(value = "Treport",method= RequestMethod.GET)
    public @ResponseBody


ModelAndView TherapistReport(Model model, HttpServletRequest request , RedirectAttributes redirectAttributes
		 ) throws ParseException
{
 
       ModelAndView modelAndView = new ModelAndView("Treport");
       int userId = (int)request.getSession().getAttribute("userId");
       if(request.getSession().getAttribute("userId") != null)
       {
      	modelAndView = new ModelAndView("Treport");
          System.out.println("User Id "+userId);
          System.out.println("Therapist ID "+request.getSession().getAttribute("loginId"));
  		int therapistId = (int) request.getSession().getAttribute("loginId");
  		Therapist therapist = therapistServiceApi.findById(therapistId);
  		if (request.getSession().getAttribute("userId") != null) {
  			if (therapist != null) {
  				System.out.println("Therapist Name ::" + therapist.getTherapistName());
  				model.addAttribute("therapistName", therapist.getTherapistName());
  				model.addAttribute("CreatedOn", therapist.getCreatedDate());
  				model.addAttribute("Email", therapist.getUser().getEmail());
  				model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
  				model.addAttribute("contactNo", therapist.getTherapistContact());
  				model.addAttribute("UserPic", therapist.getUser().getUserPic());
  			}
  			
  			System.out.println("assignedId in Controller :: "+ request.getSession().getAttribute("assignedId") );
          	ReportDomain reportDomain =new ReportDomain();
          //  int id=Integer.valueOf((String)request.getSession().getAttribute("assignedId"));

         //   Patient patient= patientServiceApi.findById(id);
AssignedChapterTherapist assignedChapter= assignedChapterServiceApi.findById(4(int)request.getSession().getAttribute("assignedId"));
           
            	 reportDomain.setPatientName(assignedChapter.getPatient().getPatientName());
                 reportDomain.setAge(assignedChapter.getPatient().getPatientAge());
                 reportDomain.setAllergies(assignedChapter.getPatient().getAllergies());
                 reportDomain.setContactNum(assignedChapter.getPatient().getContactNum());
                 reportDomain.setdOB(assignedChapter.getPatient().getPatientDob());
                 reportDomain.setGuardianName(assignedChapter.getPatient().getPatientGuardianName());
                 reportDomain.setDate(assignedChapter.getPatient().getCreatedDate());
                 reportDomain.setGender(assignedChapter.getPatient().getPatientGender());
                 reportDomain.setLanguage(assignedChapter.getPatient().getLanguageSpoken());
                 reportDomain.setDate(assignedChapter.getPatient().getCreatedDate());
                 
         		 	 model.addAttribute("guardianName",reportDomain.getGuardianName());
            		 model.addAttribute("age",reportDomain.getAge());
            		 model.addAttribute("gender",reportDomain.getGender());
            		 model.addAttribute("date",reportDomain.getDate());
            		 model.addAttribute("patientName",reportDomain.getPatientName());
            		 model.addAttribute("dOB",reportDomain.getdOB());
            		 model.addAttribute("contactNum",reportDomain.getContactNum());
            		 model.addAttribute("language",reportDomain.getLanguage());
            		 model.addAttribute("Allergies",reportDomain.getAllergies());
            	
            		 System.out.println("Patient Name" +assignedChapter.getPatient().getPatientName());
            	
            	
            		reportDomain.setLesson(assignedChapter.getLesson().getLesson());
            		model.addAttribute("lesson",reportDomain.getLesson());
                	System.out.println("*******************************");
                	System.out.println("LessonId  "+assignedChapter.getLesson().getLessonId());
                	System.out.println("LessonName "+assignedChapter.getLesson().getLesson());
                	System.out.println("Assigned Chap Id :: "+assignedChapter.getAssignedChapterId());
                	
                	for(PatientProgressSentences patientProgressSentences : assignedChapter.getPatientProgressSentences())
                	{
                		
                		reportDomain.setPatientProgressSentences(patientProgressSentences.getPatientProgressSentences());
                		model.addAttribute("Patientprogresssentence",reportDomain.getPatientProgressSentences());
                		System.out.println("Sentences Remarks "+patientProgressSentences.getPatientProgressSentences());
                    	System.out.println("*******************************");
                		System.out.println("Sentence Id :: "+patientProgressSentences.getPatientProgressSentencesId());
                	}
                	
                	for(PatientProgressSound patientProgressSound : assignedChapter.getPatientProgressSound())
                	{	
                		reportDomain.setPatientProgressSound(patientProgressSound.getPatientProgressSound());
                		model.addAttribute("patientProgressSound",reportDomain.getPatientProgressSound());
                		System.out.println("Sounds Remarks :: "+patientProgressSound .getPatientProgressSound());
                	}
                	for(PatientsProgressWord patientsProgressWord : assignedChapter.getPatientsProgressWord())
                	{
                		reportDomain.setPatientProgressWord(patientsProgressWord.getPatientsprogress());
                		model.addAttribute("patientProgressWord",reportDomain.getPatientProgressWord());
                		System.out.println("Word" + patientsProgressWord.getPatientsprogressId());
                	}
                	
                	
                }
                
                for(Records recordedAudio: assignedChapter.getPatient().getRecordedAudio())
                {

                	System.out.println("RecordedAudios "+recordedAudio.getRecordedAudioId());
                }
            }


          
        	  
          
	return modelAndView;
    
}
*/
}

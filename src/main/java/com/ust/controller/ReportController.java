package com.ust.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Patient;
import com.ust.entity.PatientProgressSentences;
import com.ust.entity.PatientProgressSound;
import com.ust.entity.PatientsProgressWord;
import com.ust.entity.Records;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;
import com.ust.domain.ReportDomain;
import com.ust.domain.UserDomain;
import com.ust.entity.User;


@Controller
public class ReportController
{
 
 @Autowired PatientserviceApi patientserviceApi;
 
 @Autowired UserServiceApi userServiceApi;
 @Autowired TherapistServiceApi therapistServiceApi;
 
    @RequestMapping(value = "Report",method= RequestMethod.GET)
    public @ResponseBody


ModelAndView Report(Model model, HttpServletRequest request , RedirectAttributes redirectAttributes) throws ParseException
{
 
       ModelAndView modelAndView;
       
 

       
 if(request.getSession().getAttribute("userId") != null)
 {
	modelAndView = new ModelAndView("Report");
    int patientId = (int) request.getSession().getAttribute("loginId");
    Patient patient = patientserviceApi.findById(patientId); 
   
		

    
    if(patient != null)
  {
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
    	
    	ReportDomain reportDomain =new ReportDomain();
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
   		
   		 

         System.out.println("Patients Language ::"+patient.getLanguageSpoken());

        System.out.println("Patients Language ::"+reportDomain.getLanguage());
        System.out.println("Report's Patient:: "+reportDomain.getPatientName());
        System.out.println("Report Date :: " +reportDomain.getDate());
        System.out.println("Therapist Name"+patient.getTherapist().getTherapistName());
        reportDomain.setTherapistName(patient.getTherapist().getTherapistName());
        
        model.addAttribute("therapistName",reportDomain.getTherapistName());
        
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

        		
        		System.out.println("Sentences Remarks "+reportDomain.getPatientProgressSentences());
            	System.out.println("*******************************");
        		System.out.println("Sentence Id :: "+patientProgressSentences.getPatientProgressSentencesId());
        	}
        	
        	for(PatientProgressSound patientProgressSound : assignedChapterTherapist.getPatientProgressSound())
        	{
        		reportDomain.setPatientProgressSound(patientProgressSound.getPatientProgressSound());
        		model.addAttribute("patientProgressSound",reportDomain.getPatientProgressSound());

        		
        		System.out.println("*******************************");
        		System.out.println("Sounds Id :: "+patientProgressSound .getPatientProgressSoundId());
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
      		 //model.addAttribute("patientProgressWord_RecordedAurdio",reportDomain.getPatientProgressWord_RecordedAudio());
       		 model.addAttribute("patientProgressSound_RecordedAudio",reportDomain.getPatientProgressSentences_RecordedAudio());
       		 model.addAttribute("patientProgressSentences_RecordedAudio",reportDomain.getPatientProgressSentences_RecordedAudio());

        	System.out.println("RecordedAudios "+recordedAudio.getRecordedAudioId());
        }
		System.out.println("*******************************");
		System.out.println("Size"+patient.getAssignedchapterTherapist().size());
    	return modelAndView;
  }
  
 }
 else
 {
  redirectAttributes.addFlashAttribute("message", "Session has been expired please 'Login' Again");
  modelAndView = new ModelAndView("redirect:/user/LoginUser");
 }
return modelAndView;
}
}    

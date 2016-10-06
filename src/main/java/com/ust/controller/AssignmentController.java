package com.ust.controller;

import java.text.ParseException;
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

import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.City;
import com.ust.entity.Lesson;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.AssignedChapterTherapistServiceApi;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;

@Controller

public class AssignmentController {

	@Autowired
	UserServiceApi userServiceApi;
	@Autowired
	TherapistServiceApi therapistServiceApi;
	@Autowired
	PatientserviceApi patientServiceApi;
	@Autowired
	LessonServiceApi lessonServiceApi;
	@Autowired
	AssignedChapterTherapistServiceApi assignedChapterTherapistServiceApi;

	@RequestMapping(value = "Assignment", method = RequestMethod.GET)
	public @ResponseBody ModelAndView Assignment(Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("Assignment");
		int userId = (int) request.getSession().getAttribute("userId");
		int therapistId = (int) request.getSession().getAttribute("loginId");
		Therapist therapist = therapistServiceApi.findById(therapistId);
		List<Lesson> lessonList = lessonServiceApi.findAll();
		model.addAttribute("lessonList", lessonList);
		if (request.getSession().getAttribute("userId") != null) {
			if (therapist != null) {
				System.out.println("Therapist Name ::" + therapist.getTherapistName());
				model.addAttribute("therapistName", therapist.getTherapistName());
				model.addAttribute("CreatedOn", therapist.getCreatedDate());
				model.addAttribute("Email", therapist.getUser().getEmail());
				model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
				model.addAttribute("contactNo", therapist.getTherapistContact());
				model.addAttribute("UserPic", therapist.getUser().getUserPic());


				for (Patient patient : therapist.getPatient()) {

					System.out.println("Patient Name  ::" + patient.getPatientName());
					model.addAttribute("patientList", therapist.getPatient());
					model.addAttribute("patientName", patient.getPatientName());
					model.addAttribute("patientAge", patient.getPatientAge());
					model.addAttribute("patientGender", patient.getPatientGender());

				}
			}
			return modelAndView;
		} else {
			redirectAttributes.addFlashAttribute("message", "Session has been expired please 'Login' Again");
			modelAndView = new ModelAndView("redirect:/user/LoginUser");
		}
		return modelAndView;

	}

	@RequestMapping(value = "AssignLesson", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> AssignLesson(@RequestBody Map<String, Object> map,
			HttpServletRequest request, Model model) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		try {
			if (map.containsKey("patientId")) 
			{
				System.out.println("PatientID:: " + map.get("patientId"));
				System.out.println("Lesson Id:: " + map.get("lessonId"));

				int userId = (int) request.getSession().getAttribute("userId");
				int therapistId = (int) request.getSession().getAttribute("loginId");

				Therapist therapist = therapistServiceApi.findById((therapistId));
				System.out.println("Therapist Id::" + therapist.getTherapistId());

				if (therapist == null)
				{
					System.out.println("UserName not found");
					header.put("message", "Username doesnot exist");
					header.put("status", 200);
				} 
				else 
				{
					Lesson lesson = new Lesson();
					Patient patient = new Patient();

					int id = Integer.valueOf((String) map.get("lessonId"));
					int idPatient = Integer.valueOf((String) map.get("patientId"));
					System.out.println("Id Testing Lesson ::" + id);

					lesson.setLessonId(id);
					patient.setPatientId(idPatient);

					AssignedChapterTherapist assignedChapterTherapist = new AssignedChapterTherapist();
					assignedChapterTherapist.setLesson(lesson);

					assignedChapterTherapist.setPatient(patient);

					assignedChapterTherapistServiceApi.saveOrUpdate(assignedChapterTherapist);
					header.put("message", "Lesson has been Assigned Thanks !!");
					header.put("status", 404);
				}
			} 
			else 
			{
				header.put("message", "Error");
			}

			result.put("header", header);

			return result;

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			model.addAttribute("error", "Email already exist.You are already Registered!");
			return result;

		}

	}
}

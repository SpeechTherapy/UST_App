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

import com.ust.domain.AssignedLessonListDomain;
import com.ust.entity.AssignedChapterTherapist;
import com.ust.entity.Lesson;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.AssignedChapterTherapistServiceApi;
import com.ust.service.api.LessonServiceApi;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.TherapistServiceApi;

@Controller
@RequestMapping(value = "user")
// Therapist Lesson List
public class LessonsController {
	@Autowired
	TherapistServiceApi therapistServiceApi;
	@Autowired
	LessonServiceApi lessonServiceApi;
	@Autowired
	PatientserviceApi patientServiceApi;

	@RequestMapping(value = "Lessons")
	public ModelAndView Lessons(Model model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("Lessons");
		int userId = (int) request.getSession().getAttribute("userId");
		int therapistId = (int) request.getSession().getAttribute("loginId");
		Therapist therapist = therapistServiceApi.findById(therapistId);
		if (request.getSession().getAttribute("userId") != null) {
			if (therapist != null) {
				model.addAttribute("therapistName", therapist.getTherapistName());
				model.addAttribute("CreatedOn", therapist.getCreatedDate());
				model.addAttribute("Email", therapist.getUser().getEmail());
				model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
				model.addAttribute("contactNo", therapist.getTherapistContact());
				model.addAttribute("UserPic", therapist.getUser().getUserPic());

			}
		}
		List<Lesson> lessonList = lessonServiceApi.findAll();

		System.out.println(" Lesson List::" + lessonList.size());

		if (lessonList.size() > 0) {
			model.addAttribute("lessonList", lessonList);

			for (Lesson lesson : lessonList) {

			}
		}

		return modelAndView;
	}

	@Autowired
	AssignedChapterTherapistServiceApi assignedChapterTherapist;

	@RequestMapping(value = "AssignedLessonList")
	public ModelAndView AssignedLessonList(Model model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("AssignedLessonList");

		if (request.getSession().getAttribute("loginId") != null) {
		int therapistId = (int) request.getSession().getAttribute("loginId");
		Therapist therapist = therapistServiceApi.findById(therapistId);
		AssignedLessonListDomain assignedLessonListDomain = new AssignedLessonListDomain();
			if (therapist != null) {
				model.addAttribute("assignedPatients", therapist);

				System.out.println("Therapist Name ::" + therapist.getTherapistName());
				model.addAttribute("therapistName", therapist.getTherapistName());
				model.addAttribute("CreatedOn", therapist.getCreatedDate());
				model.addAttribute("Email", therapist.getUser().getEmail());
				model.addAttribute("Hospital", therapist.getHospital().getHospitalName());
				model.addAttribute("contactNo", therapist.getTherapistContact());
				model.addAttribute("UserPic", therapist.getUser().getUserPic());

				model.addAttribute("patientList", therapist.getPatient());
				for (Patient patient : therapist.getPatient()) {
					assignedLessonListDomain.setPatientName(patient.getPatientName());
					assignedLessonListDomain.setPatientAge(patient.getPatientAge());
					assignedLessonListDomain.setPatientGender(patient.getPatientGender());

					System.out.println("Patient Name  ::" + assignedLessonListDomain.getPatientName());
					model.addAttribute("patientName", assignedLessonListDomain.getPatientName());
					model.addAttribute("patientAge", assignedLessonListDomain.getPatientAge());
					model.addAttribute("patientGender", assignedLessonListDomain.getPatientGender());

					for (AssignedChapterTherapist assignedChapterTherapist : patient.getAssignedchapterTherapist()) {
						model.addAttribute("assignedChapterList", patient.getAssignedchapterTherapist());
						assignedLessonListDomain.setLessonName(assignedChapterTherapist.getLesson().getLesson());
						System.out.println("Assigned Chapter:: " + assignedLessonListDomain.getLessonName());
					}
				}
			}
		}else{
			//PLease write session expires code here Thanks
		}
		return modelAndView;
	}

	// Admin Lesson List
	@RequestMapping(value = "DbLesson", method = RequestMethod.GET)
	public ModelAndView DbLesson(Model model, HttpServletRequest request, @ModelAttribute Lesson lessons) {
		ModelAndView modelAndView = new ModelAndView("DbLesson");

		List<Lesson> lessonList = lessonServiceApi.findAll();

		System.out.println(" Lesson List::" + lessonList.size());

		if (lessonList.size() > 0) {
			model.addAttribute("lessonList", lessonList);

			for (Lesson lesson : lessonList) {

			}
		}

		return modelAndView;
	}

	@RequestMapping(value = "SetLessonId", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> SetLessonId(@RequestBody Map<String, Object> map,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();

		if (map.containsKey("lessonId")) {
			System.out.println("lessonId Checkinggggg:: " + map.get("lessonId"));
			request.getSession().setAttribute("lessonId", map.get("lessonId"));

		}

		return result;

	}

}

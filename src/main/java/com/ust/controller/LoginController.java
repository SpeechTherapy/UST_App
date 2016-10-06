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

import com.ust.domain.PatientDomain;
import com.ust.domain.TherapistDomain;
import com.ust.entity.Admin;
import com.ust.entity.Lesson;
import com.ust.entity.Patient;
import com.ust.entity.Therapist;
import com.ust.entity.User;
import com.ust.service.api.PatientserviceApi;
import com.ust.service.api.TherapistServiceApi;
import com.ust.service.api.UserServiceApi;

@Controller
@RequestMapping(value = "user")
public class LoginController {

	@Autowired
	private UserServiceApi userServiceApi;

	@Autowired
	private PatientserviceApi patientServiceApi;

	@Autowired
	TherapistServiceApi therapistServiceApi;

	@RequestMapping(value = "/")
	public ModelAndView homepage() {
		ModelAndView modelAndView = new ModelAndView("homepage");

		return modelAndView;
	}

	@RequestMapping(value = "LoginUser")
	public ModelAndView LoginUser() {
		ModelAndView modelAndView = new ModelAndView("LoginUser");

		return modelAndView;
	}

	@RequestMapping(value = "register")
	public ModelAndView RegisterUser() {
		ModelAndView modelAndView = new ModelAndView("register");

		return modelAndView;
	}

	@RequestMapping(value = "selectTherapist")
	public ModelAndView selectTherapist(Model model) {
		ModelAndView modelAndView = new ModelAndView("selectTherapist");
		List<Therapist> therapistList = therapistServiceApi.findAll();
		for (Therapist therapist : therapistList) {
			model.addAttribute("therapistList", therapistList);
			model.addAttribute("therapistName", therapist.getTherapistName());
			model.addAttribute("therapistContact", therapist.getTherapistContact());
			model.addAttribute("hospital", therapist.getHospital().getHospitalName());
			System.out.println("Testing Therapist Names " + therapist.getTherapistName());
		}

		return modelAndView;
	}

	@RequestMapping(value = "SetTherapistId", method = RequestMethod.POST)
	public @ResponseBody ModelAndView SetLessonId(@RequestBody Map<String, Object> map, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("termsAndConditions");

		if (map.containsKey("therapistId")) {
			System.out.println("Checkinggggg:: " + map.get("therapistId"));
			ModelAndView model = new ModelAndView("redirect:/user/termsAndConditions");

			Therapist therapist = therapistServiceApi.findById((int) map.get("therapistId"));
			System.out.println("TherapistID  "+therapist);
			Patient patient =new Patient();
			User user=userServiceApi.findById((int) request.getSession().getAttribute("patientId"));
			System.out.println("LoginId :: "+request.getSession().getAttribute("loginId"));
			System.out.println("testing patientId ::" + request.getSession().getAttribute("patientId"));
			patient.setTherapist(therapist);
			patient.setUser(user);
			patientServiceApi.save(patient);
			request.getSession().setAttribute("PatientID", patient.getPatientId());
			System.out.println("testing patientId ::" + request.getSession().getAttribute("PatientID"));

			return model;
		}

		return modelAndView;

	}

	@RequestMapping(value = "termsAndConditions")
	public ModelAndView termsAndConditions() {
		ModelAndView modelAndView = new ModelAndView("termsAndConditions");
		return modelAndView;
	}

	@RequestMapping(value = "WelcomePatient")
	public ModelAndView WelcomePatient(Model model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("WelcomePatient");
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
		}		return modelAndView;
	}

	@RequestMapping(value = "WelcomeAdmin")
	public ModelAndView WelcomeAdmin(Model model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("WelcomeAdmin");
		modelAndView.addObject("Name", request.getAttribute("Name"));
		return modelAndView;
	}

	@RequestMapping(value = "WelcomeTherapist") // Welcome Therapist
	public ModelAndView WelcomeUser(Model model, HttpServletRequest request, @ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("WelcomeTherapist"); 
		int userId = (int) request.getSession().getAttribute("userId");
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
		}
		return modelAndView;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	ModelAndView UserLogin(@ModelAttribute User user, Model model, HttpServletRequest request,
			RedirectAttributes redirectattributes) {

		if (!user.getUserName().isEmpty() && !user.getUserPassword().isEmpty()) {
			System.out.println("userId in Service" + user.getUserName() + "password" + user.getUserPassword());
			user = userServiceApi.LoginUser(user.getUserName(), user.getUserPassword());

			if (user != null) {
				request.getSession().setAttribute("userId", user.getUserId());
				System.out.println("userId " + user.getUserName());
				System.out.println("User Password " + user.getUserPassword());

				if (user.getTherapist() != null && user.getTherapist().size() > 0 && user.getUserIsActive() != 0) {
					System.out.println("In therapist");
					ModelAndView welcome = new ModelAndView("redirect:WelcomeTherapist");

					for (Therapist therapist : user.getTherapist()) {
						request.getSession().setAttribute("loginId", therapist.getTherapistId());
						System.out.println("Therapist" + therapist.getTherapistId());
					}

					return welcome;

				}
				System.out.println("Check complete");

				if (user.getPatient() != null && user.getPatient().size() > 0 && user.getUserIsActive() != 0) {
					ModelAndView patientwelcome = new ModelAndView("redirect:WelcomePatient");

					for (Patient patient : user.getPatient()) {
						request.getSession().setAttribute("loginId", patient.getPatientId());
						System.out.println("Patient" + patient.getPatientId());
					}
					return patientwelcome;
				} else if (user.getTherapist() != null && user.getTherapist().size() > 0 && user.getUserIsActive() == 0
						|| user.getPatient() != null && user.getPatient().size() > 0 && user.getUserIsActive() == 0) {
					System.out.print("In ELSE IF");
					redirectattributes.addFlashAttribute("message",
							"Your account has been deactivated. Kindly contact admin");
					ModelAndView modelAndView = new ModelAndView("redirect:/user/LoginUser");
					return modelAndView;
				}

				if (user.getAdmin() != null && user.getAdmin().size() > 0) {
					ModelAndView adminwelcome = new ModelAndView("redirect:WelcomeAdmin");

					for (Admin admin : user.getAdmin()) {
						request.getSession().setAttribute("loginId", admin.getAdminId());
						System.out.println("Admin" + admin.getAdminId());
					}
					return adminwelcome;
				}
			}

			else {
				System.out.print("In ELSE");
				redirectattributes.addFlashAttribute("message", "Invalid Email or Password");
				ModelAndView modelAndView = new ModelAndView("redirect:/user/LoginUser");
				return modelAndView;
			}
		}

		return null;
	}

	private void elseif() {
		// TODO Auto-generated method stub

	}

	/// Patient's Registeration
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String Registration(@ModelAttribute User user, Model model, @ModelAttribute PatientDomain patientDomain,
			HttpServletRequest request, RedirectAttributes redirectattributes) {

		try {
			if (user != null) {
				System.out.println("Test  Email " + user.getEmail());
				System.out.println("Test  UserName " + user.getUserName());
				System.out.println("Test  Password " + user.getUserPassword());

			}
			if (!user.getUserName().isEmpty() && !user.getUserPassword().isEmpty())

			{

				Patient patient = new Patient();
				user.setUserIsActive(1);
				userServiceApi.save(user);
				/*patientDomain.setPatientUsername(user.getUserName());
				patient.setPatientUsername(patientDomain.getPatientUsername());
				patient.setUser(user);
				System.out.println(user.getUserName());

				patientServiceApi.save(patient);*/

				request.getSession().setAttribute("patientId", user.getUserId());
				System.out.println("PatientId "+request.getSession().getAttribute("patientId"));
			}

			return "redirect:selectTherapist";

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			redirectattributes.addFlashAttribute("message", "You are already Registered!");
			model.addAttribute("error", "Email already exist.You are already Registered!");
			return "redirect:register";
		}

	}

	@RequestMapping(value = "logout")
	public  @ResponseBody ModelAndView Logout(HttpServletRequest servletRequest, RedirectAttributes redirectattributes) {
		ModelAndView modelAndView=new ModelAndView("redirect:/user/LoginUser");
		servletRequest.getSession().setAttribute("loginId", null);
		servletRequest.getSession().setAttribute("userId", null);
		redirectattributes.addFlashAttribute("message", "You are successfully Logout!");
		return modelAndView;
	}
}
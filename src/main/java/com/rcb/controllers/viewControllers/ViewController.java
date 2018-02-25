package com.rcb.controllers.viewControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rcb.dtos.UserDTO;
import com.rcb.services.UserService;

@Controller
public class ViewController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getWelcomePage() {
		return "welcome";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistrationPage() {
		return "userRegistration";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getErrorPage() {
		return "error";
	}

	@RequestMapping(value = "/loginRedirect", method = RequestMethod.POST)
	public String LOaginPage() {
		return "Login";
	}

	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String geLogPage() {
		return "Login";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, ModelAndView model) {

		UserDTO user = new UserDTO();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		boolean status = userService.login(user).isSuccess();

		return status ? "redirect:/registration" : "redirect:/error";
	}

	@RequestMapping(value = "/docterAdd", method = RequestMethod.GET)
	public String getDocterAddPage() {
		return "DocterAdd";
	}

	@RequestMapping(value = "/docterList", method = RequestMethod.GET)
	public String getDocterListPage() {
		return "DocterList";
	}

}

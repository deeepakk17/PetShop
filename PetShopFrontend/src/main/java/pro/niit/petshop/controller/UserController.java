package pro.niit.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pro.niit.petshop.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	private UserDetails userDetails;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userloginpage() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView userregisterpage() {
		ModelAndView modelAndView = new ModelAndView("signup");
		modelAndView.addObject("userDetails", userDetails);
		return modelAndView;
	}
}

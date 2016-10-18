package pro.niit.petshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pro.niit.petshop.dao.CartDAO;
import pro.niit.petshop.dao.ProductDAO;
import pro.niit.petshop.dao.UserDAO;
import pro.niit.petshop.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserDetails userDetails;

	

	@Autowired
	private ProductDAO productDAO;

	String loggedInUser;

	
	//Handler for spring security login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
			modelAndView.addObject("msg", "You've been logged out successfully.");
		}
		modelAndView.setViewName("login");

		return modelAndView;

	}

	//handler to redirect user home page
	@RequestMapping(value = "/home")
	public ModelAndView gohomepage(HttpSession session, HttpServletRequest servletRequest) {
		String username = servletRequest.getUserPrincipal().getName();
		session.setAttribute("loggedInUser", username);
		ModelAndView modelAndView = new ModelAndView("homepage");
		modelAndView.addObject("productList", this.productDAO.list());
		// modelAndView.addObject("itemCount", cartDAO.itemCount(loggedInUser));
		return modelAndView;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied() {

		ModelAndView model = new ModelAndView();
		
		model.setViewName("403");
		return model;

	}
	
	
	//reset password handler
	@RequestMapping(value = "/user/resetpassword")
	public ModelAndView editProduct() {
		ModelAndView modelAndView = new ModelAndView("resetpassword");
		
		modelAndView.addObject(new UserDetails());
		return modelAndView;

	}
	
	
	//handler to change your password
	@RequestMapping(value = "/user/resetpassword", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("userDetails") UserDetails newUserPassword,HttpServletRequest servletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		String username = servletRequest.getUserPrincipal().getName();
		UserDetails userDetails = userDAO.getUserByUsername(username);
		if (newUserPassword.getPassword().equals(newUserPassword.getConfirmpassword())) {
			userDetails.setPassword(newUserPassword.getPassword());
			userDAO.saveOrUpdate(userDetails);
			modelAndView.setViewName("redirect:/home"); 
			
		}
		else {
			modelAndView.addObject("error", "Password doesn't match!");
			modelAndView.setViewName("resetpassword");
		}
		return modelAndView;
	}
	
	
}

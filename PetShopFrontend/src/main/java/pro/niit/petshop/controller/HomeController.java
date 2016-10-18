package pro.niit.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pro.niit.petshop.dao.ProductDAO;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/"  })
	public ModelAndView golanding() {
		ModelAndView mv = new ModelAndView("landing");
		mv.addObject("productList",this.productDAO.list());
		return mv;
	}
	
	//returns aboutus page
	@RequestMapping("/aboutus")
	public String goaboutus() {
		return "aboutus";
	}

	//returns the home page for admin
	@RequestMapping("/admin/home")
	public String goadminhome() {
		return "adminhome";
	}

	//handler for displaying 404 error page
	@RequestMapping("/error")
	public String goerrorpage() {

		return "404";
	}

}

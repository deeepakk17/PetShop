package pro.niit.petshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pro.niit.petshop.dao.CategoryDAO;
import pro.niit.petshop.dao.ProductDAO;
import pro.niit.petshop.model.CategoryDetails;
import pro.niit.petshop.model.ProductDetails;


@Controller
public class CategoryController {

	@Autowired
	private CategoryDetails categoryDetails;
	
	@Autowired
	private ProductDetails productDetails;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	//go to manage category page
	@RequestMapping(value = "/admin/gomanagecategories", method = RequestMethod.GET)
	public ModelAndView gomanagecategory() {
		ModelAndView modelAndView = new ModelAndView("managecategory");
		modelAndView.addObject("categoryDetails",new CategoryDetails());
		modelAndView.addObject("categoryList", this.categoryDAO.list());
		return modelAndView;
	}

	//add new category to db
	@RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
	public ModelAndView addcategory(@Valid @ModelAttribute CategoryDetails categoryDetails, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.addObject("categoryList", this.categoryDAO.list());
			modelAndView.setViewName("managecategory");
		} else {
			categoryDAO.saveOrUpdate(categoryDetails);
			
			categoryDetails= new CategoryDetails();
			modelAndView.addObject(categoryDetails);
			
			modelAndView.setViewName("managecategory");
			modelAndView.addObject("successmessage", "Category Added Successfully");
			modelAndView.addObject("categoryList", this.categoryDAO.list());
			
		}
		return modelAndView;

	}

	//update existing category
	@RequestMapping(value = "/category/edit/{id}")
	public String editcategory(@PathVariable("id") String id, Model model) {
		categoryDetails = categoryDAO.get(id);
		model.addAttribute(categoryDetails);
		return "managecategory";
	}
	
	//delete existing category
	@RequestMapping(value = "/category/delete/{id}")
	public String deletecategory(@PathVariable("id") String id, Model model) {
		
		
		
		
		List<ProductDetails> productsInCategory = productDAO.getByCategoryId(id);
		for (ProductDetails item : productsInCategory){
			productDAO.delete(item.getId());
        }	
		
		
		
		categoryDAO.delete(id);
		categoryDetails= new CategoryDetails();				
		model.addAttribute(categoryDetails);
		model.addAttribute("categoryList", this.categoryDAO.list());
		return "managecategory";
	}
	
	

	//list all category
	@RequestMapping(value = "/admin/listcategory", method = RequestMethod.GET)
	public String golistcategory(Model model) {
		model.addAttribute("categoryDetails", categoryDetails);
		model.addAttribute("categoryList", this.categoryDAO.list());
		return "viewcategory";
	}

	

}

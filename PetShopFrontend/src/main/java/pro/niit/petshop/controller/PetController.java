package pro.niit.petshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import pro.niit.petshop.dao.CategoryDAO;
import pro.niit.petshop.dao.ProductDAO;
import pro.niit.petshop.model.CategoryDetails;
import pro.niit.petshop.model.ProductDetails;

@Controller
public class PetController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductDetails productDetails;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	// angularjs view all handler
	@RequestMapping("/viewallpet")
	public ModelAndView goviewpets() {
		ModelAndView modelAndView = new ModelAndView("viewallpets");
		List<ProductDetails> productlist =  productDAO.list();
		Gson gson=new Gson();
		String item=gson.toJson(productlist);
		modelAndView.addObject("item",item);
		return modelAndView;
	}
	
	
	@RequestMapping("/goview")
	public @ResponseBody ModelAndView noangular() {
		ModelAndView modelAndView = new ModelAndView("viewall");
		//List<ProductDetails> productlist =  productDAO.list();
		//modelAndView.addObject("productList",productlist);
		return modelAndView;
	}	
	
	
	//handler for returning JSON data for angular get method
	@RequestMapping(value = "/getdata",method = RequestMethod.GET)
	public @ResponseBody List<ProductDetails> data() {		
		return this.productDAO.list();
		 
	}	
	
	//view by single product
	@RequestMapping(value = "product/view/{id}")
	public ModelAndView viewProduct(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView("view");
		productDetails = productDAO.get(id);
		modelAndView.addObject(productDetails);
		modelAndView.addObject("productList", this.productDAO.list());
		modelAndView.addObject("categoryList", this.categoryDAO.list());
		return modelAndView;

	}
	
	//delete product by ID
	@RequestMapping(value = "product/deleteitem/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView("pets");
		productDAO.delete(id);
		
		modelAndView.addObject("productList", this.productDAO.list());
		modelAndView.addObject("categoryList", this.categoryDAO.list());
		return modelAndView;
	}
	
	//View product by category
	 @RequestMapping("product/categoryview")	    
	 public ModelAndView goCategoryView(HttpServletRequest request) {
			String categoryname=request.getParameter("categoryname"); 
			CategoryDetails categoryDetails = categoryDAO.getByName(categoryname);
			
			ModelAndView modelAndView=new ModelAndView("pets");		
			modelAndView.addObject("productList",this.productDAO.getByCategoryId(categoryDetails.getId()));
			//List <ProductDetails> productList = productDAO.getByCategoryId(categoryDetails.getId());
			//List <ProductDetails> productList = productDAO.getByCategoryName(categoryname);			
			//modelAndView.addObject(productList);
			
			
	         return modelAndView;
		}
}

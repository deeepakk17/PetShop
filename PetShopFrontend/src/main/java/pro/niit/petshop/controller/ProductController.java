package pro.niit.petshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pro.niit.petshop.dao.CategoryDAO;
import pro.niit.petshop.dao.ProductDAO;
import pro.niit.petshop.handler.FileHandler;
import pro.niit.petshop.model.CategoryDetails;
import pro.niit.petshop.model.ProductDetails;

@RestController
public class ProductController {

	String path = "F:\\Deepk\\Project_Petshop\\PetShopFrontend\\src\\main\\webapp\\assets\\images\\products\\";

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private ProductDetails productDetails;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private CategoryDetails categoryDetails;

	//to manage products page for admin
	@RequestMapping(value = "/admin/gomanageproducts", method = RequestMethod.GET)
	public ModelAndView gomanageproducts() {
		ModelAndView modelAndView = new ModelAndView("manageproducts");
		modelAndView.addObject("productDetails",new ProductDetails());
		modelAndView.addObject("productList", this.productDAO.list());
		modelAndView.addObject("categoryList", this.categoryDAO.list());

		return modelAndView;
	}

	//handler to add new pets
	@RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid @ModelAttribute("productDetails") ProductDetails productDetails,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {

			modelAndView.setViewName("manageproducts");
			modelAndView.addObject("productList", this.productDAO.list());
			modelAndView.addObject("categoryList", this.categoryDAO.list());
		} else {

			MultipartFile file = productDetails.getMultipartFile();

			FileHandler.upload(path, file, productDetails.getId() + ".jpg");
			CategoryDetails categoryDetails = categoryDAO.getByName(productDetails.getCategory().getName());
			productDetails.setCategory(categoryDetails);
			productDAO.saveOrUpdate(productDetails);
		//	modelAndView = new ModelAndView();
			productDetails= new ProductDetails();
			modelAndView.addObject("productDetails",productDetails);
			modelAndView.setViewName("manageproducts");
			modelAndView.addObject("productList", this.productDAO.list());
			modelAndView.addObject("categoryList", this.categoryDAO.list());

		}
		return modelAndView;
	}
	
	
	//handler to edit existing pet information
	@RequestMapping(value = "product/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView("manageproducts");
		productDetails = productDAO.get(id);
		modelAndView.addObject(productDetails);
		modelAndView.addObject("productList", this.productDAO.list());
		modelAndView.addObject("categoryList", this.categoryDAO.list());
		return modelAndView;

	}

	
	//handler to delete existing pets
	@RequestMapping(value = "product/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView("manageproducts");
		productDAO.delete(id);
		modelAndView.addObject(new ProductDetails());
		modelAndView.addObject("productList", this.productDAO.list());
		modelAndView.addObject("categoryList", this.categoryDAO.list());
		return modelAndView;
	}
	
	
	//List all pets
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public @ResponseBody List<ProductDetails> listProduct() {
		
		List<ProductDetails> listtt  =  this.productDAO.list();
		
		return listtt;
	}

	

}

package pro.niit.petshop.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pro.niit.petshop.dao.CartDAO;
import pro.niit.petshop.dao.CartItemDAO;
import pro.niit.petshop.dao.ProductDAO;
import pro.niit.petshop.dao.UserDAO;
import pro.niit.petshop.model.CartHistory;
import pro.niit.petshop.model.CartItem;
import pro.niit.petshop.model.ProductDetails;
import pro.niit.petshop.model.UserCart;
import pro.niit.petshop.model.UserDetails;

@Controller
public class CartController {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private ProductDetails productDetails;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CartItemDAO cartItemDAO;

	

	
//add item to cart
	@RequestMapping(value = "/user/addusercart/{id}")
	public String addtousercart(@PathVariable("id") String id, HttpServletRequest servletRequest) {
			String username = servletRequest.getUserPrincipal().getName();
			UserDetails userDetails = userDAO.getUserByUsername(username);
	        UserCart userCart = userDetails.getCart();
	        ProductDetails product = productDAO.get(id);
	        DateFormat nowdate = new SimpleDateFormat("dd/MM/yyyy");
	        DateFormat nowtime = new SimpleDateFormat("hh:mm:ss");
	        Date date = new Date();
	        Calendar calender = Calendar.getInstance();
	        String currentdate = nowdate.format(date);
	        String currenttime = nowtime.format(calender.getTime());
	      //  List<CartItem> cartItems = userCart.getCartItemList();
	        
	       // List<CartItem> cartItems = cartItemDAO.getByCartId(userCart.getCartId());
	        
	        //to compare and check whether the product already exist or not
	        
	        List<CartItem> cartItems = null;
	        cartItems = cartItemDAO.getByCartId(userCart.getCartId());
	     //   System.out.println(cartItems.size());
	        if(cartItems !=  null){
	        for (int i=0; i < cartItems.size(); i++){
	            if(product.getId() == cartItems.get(i).getProducts().getId()){
	                CartItem cartItem = cartItems.get(i);
	                cartItem.setDate(currentdate);
	                cartItem.setTime(currenttime);
	                cartItem.setQuantity(cartItem.getQuantity() + 1);
	                cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
	                cartItemDAO.addCartItem(cartItem);
	                
	                //to update cartlist in usercart 
	                cartItems = cartItemDAO.getByCartId(userCart.getCartId());
	                
	        	/*	for (CartItem item : cartItems){
	        			System.out.println(item);
	                }	
	        		*/
	                
	                
	           //     userCart.setCartItemList(cartItems);
	                userCart.setGrandTotal(cartDAO.getSumOfTotalPrice(userDetails.getCart().getCartId()));
	    	        cartDAO.saveOrUpdate(userCart);

	                return "redirect:/viewallpet";
	            }
	        }
	        }
	        CartItem cartItem = new CartItem();
	        cartItem.setProducts(product);
	        cartItem.setDate(currentdate);
            cartItem.setTime(currenttime);
	        cartItem.setQuantity(1);
	        cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());

	        cartItem.setCart(userCart);
	        cartItemDAO.addCartItem(cartItem);//save or update
	        
	        userCart.setGrandTotal(cartDAO.getSumOfTotalPrice(userDetails.getCart().getCartId()));
	        cartDAO.saveOrUpdate(userCart);
	        return "redirect:/viewallpet";
	    }

	

	/*@RequestMapping(value = "/user/viewcart")
	public ModelAndView viewcart(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("viewcart");
		// modelAndView.addObject("cartList", cartDAO.list());
		modelAndView.addObject("cart", new Cart());
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		modelAndView.addObject("cartList", cartDAO.listByUsername(loggedInUser));
		modelAndView.addObject("totalAmount", cartDAO.getTotalAmount(loggedInUser));
		// modelAndView.addObject("itemCount", cartDAO.itemCount(loggedInUser));
		return modelAndView;

	}*/
	
	//view user cart
	@RequestMapping(value = "/user/viewusercart")
    public String getCart(HttpServletRequest servletRequest){
		String username = servletRequest.getUserPrincipal().getName();
		UserDetails userDetails = userDAO.getUserByUsername(username); 

        int cartId = userDetails.getCart().getCartId();
        
        return "redirect:/user/viewusercart/" + cartId;
    }
	
	// called by view cart function
	@RequestMapping("/user/viewusercart/{cartId}")
    public ModelAndView getCartRedirect(@PathVariable (value = "cartId") int cartId){
		ModelAndView modelAndView = new ModelAndView("viewcart");
		modelAndView.addObject("cart", new UserCart());
		modelAndView.addObject("cartList", cartDAO.getCartItemById(cartId));		
		UserCart itemList =new UserCart() ;
		modelAndView.addObject("totalAmount", cartDAO.getGrantTotal(cartId));
		//itemList.setCartItemList(cartDAO.getCartItemById(cartId));
		
		
		//List<UserCart> productsInCartList = (List<UserCart>) cartDAO.getCartById(cartId);
	//	for (UserCart item : productsInCartList){
	//		System.out.println(item);        }	
		
		
		modelAndView.addObject("cartId", cartId);
      //  UserCart userCart  = cartDAO.getUserCartList(cartId);
       
        return modelAndView;
    }
	
	// to view cart history
	@RequestMapping(value = "/user/carthistory")
    public ModelAndView getcarthistory(HttpServletRequest servletRequest){
		String username = servletRequest.getUserPrincipal().getName();
		UserDetails userDetails = userDAO.getUserByUsername(username); 

        int cartId = userDetails.getCart().getCartId();
        
        ModelAndView modelAndView = new ModelAndView("orderhistory");
		modelAndView.addObject("cart", new CartHistory());
		modelAndView.addObject("cartList", cartDAO.getCartHistoryById(cartId));		
       
        return modelAndView;
    }
	
	



	//delete cart by id
	@RequestMapping("/deletecart/{id}")
	public String deletecart(@PathVariable("id") int id,HttpServletRequest servletRequest ) {
		cartDAO.delete(id);
		String username = servletRequest.getUserPrincipal().getName();
		UserDetails userDetails = userDAO.getUserByUsername(username);
        UserCart userCart = userDetails.getCart();
        userCart.setGrandTotal(cartDAO.getSumOfTotalPrice(userDetails.getCart().getCartId()));
        cartDAO.saveOrUpdate(userCart);
		
		return "redirect:/user/viewusercart";
	}
	
	
		/*@RequestMapping("/deletecart/{id}")
		public String deletecart(@PathVariable("id") int id) {
			cartDAO.delete(id);
			return "redirect:/user/viewusercart";
		}*/

/*	-----------------------------------------------------------------------------------------------*/
	/*
	@RequestMapping("/checkOut/{username}")
	public String callcheckOut(@PathVariable("username") String username) {
		Order order = new Order();
		UserDetails user = userDAO.getUserByUsername(username);
		order.setUser(user);
		
		 * List<Cart> cartItem = cartDAO.listByUsername(user.getUsername());
		 * order.setCart(cartItem);
		 
		return "redirect:/purchase.obj";

	}

	
	 * @RequestMapping("/getUserCart}") public UserCart
	 * getUserCart(HttpServletRequest servletRequest){ String loggedInUser =
	 * servletRequest.getRemoteUser(); UserCart userCart = new UserCart();
	 * userCart=cartDAO.getUserCart(loggedInUser); return userCart; }
	 */

}
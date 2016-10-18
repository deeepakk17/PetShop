package pro.niit.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pro.niit.petshop.dao.CartDAO;
import pro.niit.petshop.dao.OrderDAO;
import pro.niit.petshop.model.OrderDetails;

@Controller
public class OrderController {
	
	@Autowired
    private CartDAO cartDAO;
	
	@Autowired
    private OrderDAO orderDAO ;
	
	@Autowired
    private OrderDetails orderDetails ;
	
	
	//redirect to checkoutflow
	@RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
       /* OrderDetails order = new OrderDetails();
        UserCart cart = cartDAO.getCartById(cartId);
        order.setCart(cart);
        UserDetails userDetails = cart.getUserDetails();
        order.setUser(userDetails);
       // order.setAddress(userDetails.getAddress());
       

        orderDAO.addCustomerOrder(order);*/

        return "redirect:/checkout?cartId=" + cartId;

    }
	
	//----------------------------------------------------------------------------------------
	
	//to display orders to admin
	@RequestMapping(value="/order/view", method = RequestMethod.GET)
    public ModelAndView viewOrder(){
		
		ModelAndView modelAndView=new ModelAndView("vieworder");	
		List<OrderDetails> orderList=orderDAO.list();
		modelAndView.addObject(orderList);
		//modelAndView.addObject("orderList", this.orderDAO.list());
		return modelAndView;

    }
	
	
	

}

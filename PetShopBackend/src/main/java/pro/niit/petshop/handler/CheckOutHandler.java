package pro.niit.petshop.handler;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pro.niit.petshop.dao.CartItemDAO;
import pro.niit.petshop.dao.OrderDAO;
import pro.niit.petshop.dao.ProductDAO;
import pro.niit.petshop.dao.UserDAO;
import pro.niit.petshop.model.Address;
import pro.niit.petshop.model.CartHistory;
import pro.niit.petshop.model.CartItem;
import pro.niit.petshop.model.OrderDetails;
import pro.niit.petshop.model.ProductDetails;
import pro.niit.petshop.model.UserDetails;


@Controller
public class CheckOutHandler {
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderDetails orderDetails;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProductDAO productDAO;
		
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	
	public OrderDetails initFlow() {
		return new OrderDetails();
	}
	
	public Address saveAddress(Address address) {
		
		orderDAO.addCustomerAddress(address);
		
		// orderDAO.get(address.getAddressId());
		return address;
	}
	
	public void saveOrUpdate(OrderDetails orderDetails) {
		
		
		orderDAO.saveOrUpdate(orderDetails);
		
		List<CartItem> cartItems =  null ;		
		cartItems	= cartItemDAO.getByCartId(orderDetails.getUser().getCart().getCartId());
        CartHistory cartHistory = new CartHistory();
        for (CartItem item : cartItems){
        	
        	//reducing the product quantity on checkout
        	ProductDetails product = productDAO.get(item.getProducts().getId());
        	product.setQuantity(product.getQuantity()-item.getQuantity());
       	productDAO.saveOrUpdate(product); // updating the database with new available stock
        	
        	cartHistory.setCartItemId(item.getCartItemId());
        	cartHistory.setDate(item.getDate());
        	cartHistory.setProducts(item.getProducts());
        	cartHistory.setQuantity(item.getQuantity());
        	cartHistory.setTime(item.getTime());
        	cartHistory.setTotalPrice(item.getTotalPrice());
        	cartHistory.setUserCart(item.getCart());
        	cartHistory.setOrderId(orderDetails.getOrderId());
        	cartItemDAO.saveOrUpdate(cartHistory);
        	cartItemDAO.delete(item.getCartItemId());
        }	
        		
	}

	/*@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	public UserCart getCart() {
		
		return null;
	}
	
	public UserCart getCart(String loggedInUser){
		UserCart  userCart =	new UserCart();
		userCart=cartService.getUserCart(loggedInUser);			
		return userCart;		
	}
	
	public void takeOrder(OrderDetails order) {
		orderService.saveOrUpdate(order);
		
	}*/
	

	
	
	
}
/*package pro.niit.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;

import pro.niit.petshop.dao.CartDAO;
import pro.niit.petshop.model.UserCart;

public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public UserCart getUserCart(String loggedInUser) {
		UserCart  userCart =	new UserCart();
		userCart=cartDAO.getUserCart(loggedInUser);			
		return userCart;
	}
	
	
}
*/
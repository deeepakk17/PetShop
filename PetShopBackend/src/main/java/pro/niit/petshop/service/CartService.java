package pro.niit.petshop.service;

import pro.niit.petshop.model.UserCart;

public interface CartService {

	public UserCart getUserCart(String loggedInUser);
}

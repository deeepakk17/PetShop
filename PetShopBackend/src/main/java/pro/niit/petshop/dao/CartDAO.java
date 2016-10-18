package pro.niit.petshop.dao;

import java.util.List;

import pro.niit.petshop.model.CartHistory;
import pro.niit.petshop.model.CartItem;
import pro.niit.petshop.model.UserCart;
import pro.niit.petshop.model.UserDetails;

public interface CartDAO {

	public void saveOrUpdate(UserCart userCart);
	public UserCart getCartById(int id);
	public List<CartItem> getCartItemById(int id);
	public List<CartHistory> getCartHistoryById(int id) ;
	public void delete(int  id);
//	public UserCart getCartList(int cartId);
	public Double getSumOfTotalPrice(int cartId);
	public Double getGrantTotal(int cartId); 
//	public Long getTotalAmount(String loggedInUser);
	//public int itemCount(String username);
	public UserCart getUserCartList(int cartId);
	public UserDetails getUserByCartID(int cartId);
	
	
	//public UserCart getUserCart(String loggedInUser);
}

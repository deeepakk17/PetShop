package pro.niit.petshop.dao;

import java.util.List;

import pro.niit.petshop.model.CartHistory;
import pro.niit.petshop.model.CartItem;

public interface CartItemDAO {

//	public int getLatestCartItemId();
	public void addCartItem(CartItem cartItem);
	public List <CartItem> getByCartId(int id);
	
	public void saveOrUpdate(CartHistory cartHistory);
	
	public void delete(int id);
}

package pro.niit.petshop.dao;

import java.util.List;

import pro.niit.petshop.model.Address;
import pro.niit.petshop.model.OrderDetails;


public interface OrderDAO {
	public void saveOrUpdate(OrderDetails orderDetails);

		
	public void addCustomerAddress(Address address);
	
	public Address get(String id);
	
	public List<OrderDetails> list() ;
	
	
	//public int getLatestCartItemId();
	

}

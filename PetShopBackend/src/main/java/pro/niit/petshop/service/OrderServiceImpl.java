package pro.niit.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;

import pro.niit.petshop.dao.OrderDAO;
import pro.niit.petshop.model.OrderDetails;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	public void saveOrUpdate(OrderDetails order){
		orderDAO.saveOrUpdate(order);
	}

	
}

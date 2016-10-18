package pro.niit.petshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pro.niit.petshop.model.Address;
import pro.niit.petshop.model.OrderDetails;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	public SessionFactory sessionFactory;
	

	@Transactional
	public void saveOrUpdate(OrderDetails orderDetails) {
		orderDetails.setUser(orderDetails.getCart().getUserDetails());
		sessionFactory.getCurrentSession().saveOrUpdate(orderDetails);
		
	}
	
	@Transactional
	public void addCustomerAddress(Address address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);
	}
	
	/*@Transactional
	public int getLatestCartItemId() {
		int id;
		String hql = "SELECT orderId FROM OrderDetails ORDER BY orderId DESC";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(1);
		if (query.uniqueResult() == null) {
			id = 0;
		} else {
			id = (int) query.uniqueResult();
		}
		return id;
	}*/

	/*@Transactional
	public void addCustomerOrder(Rder order) {
		order.setUser(order.getCart().getUserDetails());
		order.setOrderId(getLatestCartItemId()+1);
		
		for (int a=0;a<6;a++){
				sessionFactory.getCurrentSession().saveOrUpdate(order);
				
		}
	}*/

	public Address get(String id) {
		String hql="FROM Address WHERE addressId = " + "'" + id + "'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Address> listProduct = query.list();
		if(listProduct!= null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public List<OrderDetails> list() {

		@SuppressWarnings("unchecked")
		List<OrderDetails> listOrder =(List<OrderDetails>) sessionFactory.getCurrentSession().createCriteria(OrderDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listOrder;
	}

}

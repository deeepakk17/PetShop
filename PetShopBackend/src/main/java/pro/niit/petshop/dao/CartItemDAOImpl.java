package pro.niit.petshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pro.niit.petshop.model.CartHistory;
import pro.niit.petshop.model.CartItem;

@Repository("cartItemDAO")
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*@Transactional
	public int getLatestCartItemId() {
		int id;
		String hql = "SELECT cartItemId FROM CartItem ORDER BY cartitemid DESC";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(1);
		if (query.uniqueResult() == null) {
			id = 0;
		} else {
			id = (int) query.uniqueResult();
		}
		return 1;
	}*/

	@Transactional
	public void addCartItem(CartItem cartItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
	}

	@Transactional
	public List<CartItem> getByCartId(int id) {
		String hql = "from CartItem where userCart  =" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> listProduct = query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct;

		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(CartHistory cartHistory) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartHistory);
	}
	
	@Transactional
	public void delete(int id) {
		CartItem cartItemToDelete= new CartItem();
		cartItemToDelete.setCartItemId(id);
		sessionFactory.getCurrentSession().delete(cartItemToDelete);
		
	}

}

package pro.niit.petshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pro.niit.petshop.model.CartHistory;
import pro.niit.petshop.model.CartItem;
import pro.niit.petshop.model.UserCart;
import pro.niit.petshop.model.UserDetails;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	public SessionFactory sessionFactory;

	@Transactional
	public void saveOrUpdate(UserCart userCart) {
		sessionFactory.getCurrentSession().saveOrUpdate(userCart);
	}

	@Transactional
	public void delete(int id) {
		CartItem cartitem = new CartItem();
		cartitem.setCartItemId(id);
		sessionFactory.getCurrentSession().delete(cartitem);
	}
	
	@Transactional
	public Double getSumOfTotalPrice(int cartId) {
		String hql = "select sum(totalPrice)from CartItem where userCart  =" + "'" + cartId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Double totalprice =  (Double) query.uniqueResult();
		return totalprice;
	}
	
	@Transactional
	public Double getGrantTotal(int cartId) {
		String hql = "select grandTotal from UserCart where cartId  =" + "'" + cartId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Double totalamount = (Double) query.uniqueResult();
		return totalamount;
	}

	/*@Transactional
	public Long getTotalAmount(String username) {
		String hql = "select sum(price)from Cart where username  =" + "'" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long amount = (Long) query.uniqueResult();
		return amount;
	}*/

	/*
	 * @Transactional public int itemCount(String username) { String hql =
	 * "select sum(QUANTITY )from Cart where username  =" + "'" + username +
	 * "'"; Query query = sessionFactory.getCurrentSession().createQuery(hql);
	 * int count = (int) query.uniqueResult(); return count; }
	 */

	@Transactional
	public UserCart getCartById(int id) {
		String hql = "from UserCart where cartId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserCart> list = (List<UserCart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	@Transactional
	public List<CartItem> getCartItemById(int id) {
		String hql = "from CartItem where CartId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<CartItem> list = (List<CartItem>) query.list();

		if (list != null && !list.isEmpty()) {

			return list;
		}

		return null;
	}
	
	@Transactional
	public List<CartHistory> getCartHistoryById(int id) {
		String hql = "from CartHistory where CartId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<CartHistory> list = (List<CartHistory>) query.list();

		if (list != null && !list.isEmpty()) {

			return list;
		}

		return null;
	}

	@Transactional
	public UserCart getUserCartList(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		return (UserCart) session.get(UserCart.class, cartId);
	}

/*	@Transactional
	public UserCart getCartList(int cartId) {
		UserCart cart = getCartById(cartId);
		if (cart == null || cart.getCartItemList().size() == 0) {
			return null;
		}

		saveOrUpdate(cart);
		return cart;
	}

*/
	@Transactional
	public UserDetails getUserByCartID(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		return (UserDetails) session.get(UserCart.class, cartId);
	}



	/*
	 * @Override public UserCart getUserCart(String username) { String hql =
	 * "from UserCart where username  =" + "'" + username + "'"; Query query =
	 * sessionFactory.getCurrentSession().createQuery(hql); UserCart userCart =
	 * (UserCart) query.list(); return userCart; }
	 */

}

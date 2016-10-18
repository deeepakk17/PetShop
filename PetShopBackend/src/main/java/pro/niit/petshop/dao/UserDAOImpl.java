package pro.niit.petshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pro.niit.petshop.model.OTP;
import pro.niit.petshop.model.UserDetails;
import pro.niit.petshop.model.UserRole;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
	}

	@Transactional
	public void saveOrUpdate(UserRole userRole) {
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);
	}

	@Transactional
	public void saveOrUpdate(OTP otp) {
		sessionFactory.getCurrentSession().saveOrUpdate(otp);
	}

	@Transactional
	public List<UserDetails> list() {
		@SuppressWarnings("unchecked")
		List<UserDetails> listUsers = (List<UserDetails>) sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUsers;
	}

	@Transactional
	public UserDetails getUserByUsername(String username) {
		String hql = "FROM UserDetails WHERE username = " + "'" + username + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserDetails> userDetails = query.list();
		if (userDetails != null && !userDetails.isEmpty()) {
			return userDetails.get(0);
		}

		return null;
	}

	@Transactional
	public OTP getOtp(String email) {
		String hql = "FROM OTP WHERE email = " + "'" + email + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<OTP> oTP = query.list();
		if (oTP != null && !oTP.isEmpty()) {
			return oTP.get(0);
		}

		return null;
	}

	/*
	 * @Transactional public boolean checkUser(UserDetails userDetails) {
	 * boolean isvaliduser = false;
	 * 
	 * String hql="from UserDetails where username= '" +
	 * userDetails.getUsername() + "' and password='" +
	 * userDetails.getPassword() + "'"; Query query =
	 * sessionFactory.getCurrentSession().createQuery(hql);
	 * 
	 * @SuppressWarnings("unchecked") List<UserDetails> list = query.list(); int
	 * size = list.size(); if (size == 1) { isvaliduser = true;
	 * 
	 * }
	 * 
	 * return isvaliduser; }
	 */

}

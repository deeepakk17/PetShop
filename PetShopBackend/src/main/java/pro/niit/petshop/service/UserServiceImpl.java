package pro.niit.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pro.niit.petshop.dao.CartDAO;
import pro.niit.petshop.dao.UserDAO;
import pro.niit.petshop.model.OTP;
import pro.niit.petshop.model.UserCart;
import pro.niit.petshop.model.UserDetails;
import pro.niit.petshop.model.UserRole;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDAO userDAO;
	
	@Autowired 
	private CartDAO cartDAO;
	
	@Transactional
	public List<UserDetails> list() {
		return userDAO.list();
	}
	

	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		userDetails.setEnabled(true);
				
		//Setting role table
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		userRole.setUsername(userDetails);		
		userDAO.saveOrUpdate(userRole);
		
        UserCart newCart = new UserCart();
        newCart.setUserDetails(userDetails);
        cartDAO.saveOrUpdate(newCart);
        
        userDetails.setCart(newCart);
        userDAO.saveOrUpdate(userDetails);	
		
	}
	
	@Transactional
	public void saveOrUpdate(OTP otp) {
		userDAO.saveOrUpdate(otp);
	}

	@Transactional
	public UserDetails getUser(UserDetails userDetails) {
		return null; }

}

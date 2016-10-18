package pro.niit.petshop.dao;

import java.util.List;

import pro.niit.petshop.model.OTP;
import pro.niit.petshop.model.UserDetails;
import pro.niit.petshop.model.UserRole;

public interface UserDAO {

	public List<UserDetails> list();

		public void saveOrUpdate(UserDetails userDetails);
		
		public void saveOrUpdate(UserRole userRole);
		
		public void saveOrUpdate(OTP otp);
		
		public UserDetails getUserByUsername(String username);
		
		public OTP getOtp(String email);
}

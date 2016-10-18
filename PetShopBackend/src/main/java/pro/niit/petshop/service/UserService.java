package pro.niit.petshop.service;

import java.util.List;

import pro.niit.petshop.model.OTP;
import pro.niit.petshop.model.UserDetails;

public interface UserService {

	public List<UserDetails> list();
	public void saveOrUpdate(UserDetails userDetails);
	public UserDetails getUser(UserDetails userDetails);
	public void saveOrUpdate(OTP otp);
}

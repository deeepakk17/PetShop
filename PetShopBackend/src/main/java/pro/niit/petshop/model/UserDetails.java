package pro.niit.petshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Project
 * 
 *
 */
@Entity
@Table(name = "USER_DETAILS")
@Component
public class UserDetails implements Serializable {	
	
		// Pojo class for user table

		@Transient
		private static final long serialVersionUID = 4657462015039726030L;
		
		@Id
		//@Size(min = 3, message = "Username must be atleast 3 characters !")
		@Column(name = "USER_NAME", columnDefinition = "varchar(15)")
		private String username;

		//@Size(min = 3, message = "Firstname must be atleast 3 characters !")
		@Column(name = "FIRST_NAME", columnDefinition = "varchar(25)")
		private String firstname;

		//@Size(min = 1, message = "Lastname must be atleast 1 characters !")
		@Column(name = "LAST_NAME", columnDefinition = "varchar(25)")
		private String lastname;

		//@Size(min = 10, max = 10, message = "Mobilenumber must be 10 characters !")
		@Column(name = "MOBILE_NUMBER", columnDefinition = "number(10)")
		private String mobilenumber;
		
		
		@Email
		@Column(name = "EMAIL_ID")		
		private String email;
		
		
		@OneToOne
	    @JoinColumn(name = "addressId")
	    private Address address;
		
		@OneToOne
	    @JoinColumn(name = "cartId")
	    @JsonIgnore
	    private UserCart cart; 
	    
		//@Size(min = 5, max = 15, message = "Password must be atleast 5 - 15 characters !")
		@Column(name = "PASSWORD", columnDefinition = "varchar(15)")
		private String password;

		//@Size(min = 5, max = 15, message = "Password must be atleast 5 - 15 characters !")
		@Transient
		@Column(name = "CONFIRM_PASSWORD", columnDefinition = "varchar(15)")
		private String confirmpassword;

		@Column(name = "ENABLED",nullable=false)
		private boolean enabled = true;
		

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
		}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmpassword() {
			return confirmpassword;
		}

		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;		}
		

		public UserCart getCart() {
			return cart;
		}

		public void setCart(UserCart cart) {
			this.cart = cart;
		}

		@Override
		public String toString() {
			return "UserDetails [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
					+ ", mobilenumber=" + mobilenumber + ", password=" + password + ", confirmpassword=" + confirmpassword
					+ ", enabled=" + enabled + "]";
		}
	

}

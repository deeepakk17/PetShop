package pro.niit.petshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "USER_CART")
public class UserCart implements Serializable{
	
	private static final long serialVersionUID = 3998321796145582L;

    @Id
    @GeneratedValue
    private int cartId;

    /*@OneToMany(mappedBy = "cartItemId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
    private List<CartItem> cartItemList;*/
    
  //  @OneToMany(mappedBy = "cartItemId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
 //   private Set<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "username")
    private UserDetails userDetails;    
   
    private double grandTotal;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
}

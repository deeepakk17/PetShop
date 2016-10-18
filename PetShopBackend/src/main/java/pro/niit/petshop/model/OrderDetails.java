package pro.niit.petshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="ORDER_DETAILS")
@Component
public class OrderDetails implements Serializable {
		
		 private static final long serialVersionUID = 546649310334411202L;

		    @Id
		    @GeneratedValue
		    private int orderId;

		    @OneToOne
		    @JoinColumn(name = "cartId")
		    private UserCart cart;
		    
		    @Transient
		    //  @ManyToOne
		    private List<CartItem> cartItemList;

		    @OneToOne
		    @JoinColumn(name = "userId")
		    private UserDetails user;
		    
		    @OneToOne
		    @JoinColumn(name = "addressId")
		    private Address billingaddress;

			public int getOrderId() {
				return orderId;
			}

			public void setOrderId(int orderId) {
				this.orderId = orderId;
			}			

			public UserCart getCart() {
				return cart;
			}

			public void setCart(UserCart cart) {
				this.cart = cart;
			}

			public UserDetails getUser() {
				return user;
			}

			public void setUser(UserDetails user) {
				this.user = user;
			}

			public Address getBillingaddress() {
				return billingaddress;
			}

			public void setBillingaddress(Address billingaddress) {
				this.billingaddress = billingaddress;
			}

			public List<CartItem> getCartItemList() {
				return cartItemList;
			}

			public void setCartItemList(List<CartItem> cartItemList) {
				this.cartItemList = cartItemList;
			}

			
			
			
	
		    
	
	}


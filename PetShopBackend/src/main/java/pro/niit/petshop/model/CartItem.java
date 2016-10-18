package pro.niit.petshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;


@Entity
@Component
public class CartItem implements Serializable {
	
	private static final long serialVersionUID = 83698989854157L;

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private int cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private UserCart userCart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductDetails products;
    
    private String date;
    
    private String time;

    private int quantity;
    
    private double totalPrice; 
    
   
    
	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public UserCart getCart() {
		return userCart;
	}

	public void setCart(UserCart userCart) {
		this.userCart = userCart;
	}

	public ProductDetails getProducts() {
		return products;
	}

	public void setProducts(ProductDetails products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserCart getUserCart() {
		return userCart;
	}

	public void setUserCart(UserCart userCart) {
		this.userCart = userCart;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

    
    

}

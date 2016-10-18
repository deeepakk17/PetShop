/**
 * 
 */
package pro.niit.petshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Deepak
 *
 */

@Entity
public class CartHistory {

		@Id
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
	    
	    private int orderId;

		public int getCartItemId() {
			return cartItemId;
		}

		public void setCartItemId(int cartItemId) {
			this.cartItemId = cartItemId;
		}

		public UserCart getUserCart() {
			return userCart;
		}

		public void setUserCart(UserCart userCart) {
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

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		} 
		
		
		
		
	    
	    
}

package pro.niit.petshop.model;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT_DETAILS")
@Component
public class ProductDetails implements Serializable{
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -1615967554228969926L;

		@Id
		@NotEmpty(message="Product ID cannot be Empty !")
		@Column(name="ID")
		private String id; 
		
		@NotEmpty(message="Productname cannot be Empty  !")
		@Column(name="NAME")
		private String name;
		
		@Min(value=100,message="Minimum Price must be 100   !")		
		@NotNull(message="Price must be positive & cannot be null   !")
		@Column(name="PRICE")
		private Integer price ;
		
		@Min(value=1,message="Minimum quantity must be 1   !")		
		@NotNull(message="quantity cannot be null   !")
		private Integer quantity ;
		
		@NotEmpty(message="Product description cannot be Empty  !")
		@Column(name="DESCRIPTION")
		private String description;

		
		@Transient
		MultipartFile multipartFile;		
				
		/*@NotEmpty(message="Select a category  !")
		private String categoryname;
		
		public String getCategoryname() {
			return categoryname;
		}

		public void setCategoryname(String categoryname) {
			this.categoryname = categoryname;
		}*/

		
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="categoryname")
		private CategoryDetails category;
		
		public CategoryDetails getCategory() {
			return category;
		}

		public void setCategory(CategoryDetails category) {
			this.category = category;
		}
		

		

		public MultipartFile getMultipartFile() {
			return multipartFile;
		}

		public void setMultipartFile(MultipartFile multipartFile) {
			this.multipartFile = multipartFile;
		}
		
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}		
		
		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "ProductDetails [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
					+ ", description=" + description + ", category=" + category
					+ "]";
		}

		
		

		
}

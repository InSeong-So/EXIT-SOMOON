package somoonShop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name="shopping_basket")
public class ShoppingBasket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;
	
	@Column(name="id")
	private String id;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="product_count")
	private String productCount;
	
	@Column(name="put_date")
	private String putDate;
}

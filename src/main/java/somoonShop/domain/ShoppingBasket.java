package somoonShop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="shopping_basket")
public class ShoppingBasket {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="product_count")
	private String productCount;
	
	@Column(name="put_date")
	private String putDate;
}

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
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="brand_number")
	private String brandNumber;
	
	@Column(name="warehouse_code")
	private String warehouseCode;
	
	@Column(name="order_number")
	private String orderNumber;
	
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="product_price")
	private String productPrice;
	
	@Column(name="product_count")
	private String productCount;
	
	@Column(name="product_date")
	private String productDate;
	
	@Column(name="discount_rate")
	private String discountRate;
	
}

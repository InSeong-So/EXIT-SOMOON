package kr.somoonShop.domain;

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
@Table(name = "product")
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_no")
	private Long productNo;

	@Id
	@Column(name = "product_code")
	private String productCode;

	@Column(name = "brand_code")
	private String brandCode;

	@Column(name = "warehouse_code")
	private String warehouseCode;

	@Column(name = "order_code")
	private String orderCode;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "product_price")
	private String productPrice;

	@Column(name = "product_count")
	private String productCount;

	@Column(name = "product_date")
	private String productDate;

	@Column(name = "product_discount")
	private String productDiscount;

}

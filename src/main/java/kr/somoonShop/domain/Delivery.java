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
@Table(name = "delivery")
public class Delivery {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_no")
	private Long deliveryNo;

	@Id
	@Column(name = "delivery_code")
	private String deliveryCode;

	@Column(name = "post_service_code")
	private String postServiceNumber;

	@Column(name = "delivery_payment")
	private int deliveryPayment;

	@Column(name = "delivery_date")
	private String deliveryDate;

}

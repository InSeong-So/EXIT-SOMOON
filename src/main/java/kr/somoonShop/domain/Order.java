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
@Table(name = "order")
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_no")
	private Long orderNo;

	@Column(name = "account_id")
	private String accountId;

	@Column(name = "delivery_code")
	private String deliveryCode;

	@Id
	@Column(name = "order_code")
	private String orderCode;

	@Column(name = "order_Date")
	private String orderDate;

	@Column(name = "delivery_contact")
	private String deliveryContact;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "delivery_postal_code")
	private String deliveryPostalCode;

	@Column(name = "delivery_way_code")
	private String deliveryWayCode;

	@Column(name = "delivery_payment")
	private String deliveryPayment;

	@Column(name = "order_memo")
	private String orderMemo;
}

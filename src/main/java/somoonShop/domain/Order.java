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
@Table(name = "order")
public class Order {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;
	
	@Column(name="id")
	private String id;
	
	@Column(name="delivery_number")
	private String deliveryNumber;
	
	@Id
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name="order_Date")
	private String orderDate;
	
	@Column(name="delivery_contact")
	private String deliveryContact;
	
	@Column(name="delivery_address")
	private String deliveryAddress;
	
	@Column(name="delivery_postal_code")
	private String deliveryPostalCode;
	
	@Column(name="delivery_code")
	private String deliveryCode;
	
	@Column(name="delivery_payment")
	private String deliveryPayment;
	
	@Column(name="memo")
	private String memo;
}

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
@Table(name = "delivery")
public class Delivery {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "no")
	private Long no;
	
	@Id
	@Column(name = "delivery_number")
	private String deliveryNumber;
	
	@Column(name = "parcel_service_number")
	private String parcelServiceNumber;
	
	@Column(name = "payment")
	private int payment;
	
	@Column(name = "delivery_date")
	private String deliveryDate;

}

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
@Table(name="supply")
public class Supply {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;
	
	@Column(name="brand_number")
	private String brandNumber;
	
	@Id
	@Column(name="supply_number")
	private String supplyNumber;
	
	@Column(name="supply_date")
	private String supplyDate;
	
	@Column(name="supply_price")
	private String supplyPrice;
}

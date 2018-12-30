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
@Table(name="warehouse")
public class Warehouse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;
	
	@Column(name="warehouse_code")
	private String warehouseCode;
	
	@Column(name="warehouse_address")
	private String warehouseAddress;
	
	@Column(name="warehouse_contact")
	private String warehouseContact;
	
	@Column(name="warehouse_share")
	private String warehouseShare;
}

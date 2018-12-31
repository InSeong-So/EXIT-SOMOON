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
@Table(name="brand")
public class Brand {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;

	@Id
	@Column(name="brand_number")
	private String brandNumber;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="brand_contact")
	private String brandContact;
	
	@Column(name="brand_address")
	private String brandAddress;
	
	@Column(name="brand_postal_code")
	private String brandPostalCode;
	
	@Column(name="bank_code")
	private int bankCode;
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="depositor")
	private String depositor;
}

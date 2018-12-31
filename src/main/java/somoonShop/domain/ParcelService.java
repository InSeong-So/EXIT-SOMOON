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
@Table(name = "parcel_service")
public class ParcelService {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "no")
	private Long no;

	@Id
	@Column(name = "parcel_service_number")
	private String parcelServiceNumber;
	
	@Column(name = "parcel_service_name")
	private String parcelServiceName;

	@Column(name = "parcel_service_contact")
	private String parcelServiceContact;

	@Column(name = "parcel_service_address")
	private String parcelServiceAddress;

	@Column(name = "parcel_service_postal_code")
	private String parcelServicePostalCode;

	@Column(name = "bank_code")
	private String bankCode;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "depositor")
	private String depositor;
}

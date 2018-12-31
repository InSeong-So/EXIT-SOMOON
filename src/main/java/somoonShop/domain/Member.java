package somoonShop.domain;

import java.sql.Timestamp;

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
@Table(name="member")
public class Member {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="no")
	private Long no;
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birthday")
	private String birthday;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="address")
	private String address;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="email")
	private String email;
	
	@Column(name="agreement")
	private String agreement;
	
	@Column(name="add_Date")
	private Timestamp addDate;
	
	@Column(name="point")
	private int point;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="total_length")
	private String totalLength;
	
	@Column(name="shoulder_width")
	private String shoulderWidth;
	
	@Column(name="chest_width")
	private String chestWidth;
	
	@Column(name="sleeve_length")
	private String sleeveLength;
	
	@Column(name="necking")
	private String necking;
	
	@Column(name="kidney")
	private String kidney;
	
	@Column(name="neck_circumference")
	private String neckCircumference;
	
	@Column(name="overall_arm_length")
	private String overallArmLength;
	
	@Column(name="bust")
	private String bust;
	
	@Column(name="waist_circumference")
	private String waistCircumference;
	
	@Column(name="hip_circumference")
	private String hipCircumference;
}

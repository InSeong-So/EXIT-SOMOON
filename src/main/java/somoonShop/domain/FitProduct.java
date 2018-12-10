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
@Table(name="fit_product")
public class FitProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

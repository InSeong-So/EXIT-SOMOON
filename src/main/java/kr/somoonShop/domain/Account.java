package kr.somoonShop.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
public class Account {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_no")
	private Long accountNo;

	@Id
	@Column(name = "account_id")
	private String accountId;

	@Column(name = "account_password")
	private String accountPassword;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "account_birthday")
	private String accountBirthday;

	@Column(name = "account_contact")
	private String accountContact;

	@Column(name = "account_address")
	private String accountAddress;

	@Column(name = "account_postal_code")
	private String accountPostalCode;

	@Column(name = "account_email")
	private String accountEmail;

	@Column(name = "account_agreement")
	private String accountAgreement;

	@Column(name = "account_add_fit")
	private String accountAddFit;

	@Column(name = "account_add_Date")
	private Timestamp accountAddDate;

	@Column(name = "account_last_login")
	private Timestamp accountLastLogin;

	@Column(name = "account_count_login_failed")
	private int accountCountLoginFailed;

	@Column(name = "account_point")
	private int accountPoint;

}

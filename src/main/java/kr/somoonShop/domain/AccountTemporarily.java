package kr.somoonShop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account_temporarily")
public class AccountTemporarily {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_temp_no")
    private Long accountTempNo;

    @Id
    @Column(name = "account_temp_id")
    private String accountTempId;

    @Column(name = "account_temp_password")
    private String accountTempPassword;

    @Column(name = "account_temp_contact")
    private String accountTempContact;

    @Column(name = "account_temp_address")
    private String accountTempAddress;

    @Column(name = "account_temp_postal_code")
    private String accountTempPostalCode;

    @Column(name = "account_temp_add_date")
    private Timestamp accountTempAddDate;

    @Column(name = "account_temp_delyn")
    private String accountTempDelyn;
}

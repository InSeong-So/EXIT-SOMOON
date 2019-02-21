package kr.somoonShop.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "brand")
public class Brand {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_no")
    private Long brandNo;

    @Id
    @Column(name = "brand_code")
    private String brandCode;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "brand_contact")
    private String brandContact;

    @Column(name = "brand_address")
    private String brandAddress;

    @Column(name = "brand_postal_code")
    private String brandPostalCode;

    @Column(name = "brand_bank_code")
    private int brandBankCode;

    @Column(name = "brand_account_number")
    private String brandAccountNumber;

    @Column(name = "brand_depositor")
    private String brandDepositor;
}

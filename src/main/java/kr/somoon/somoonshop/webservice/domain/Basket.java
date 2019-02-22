package kr.somoon.somoonshop.webservice.domain;

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
@Table(name = "basket")
public class Basket {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_no")
    private Long basketNo;

    @Id
    @Column(name = "account_id")
    private String basketId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_count")
    private String productCount;

    @Column(name = "basket_add_date")
    private String basketPutDate;
}

package kr.somoonShop.domain;

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
@Table(name = "body_size")
public class BodySize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_size_no")
    private String bodySizeNo;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "body_sex")
    private String bodySex;

    @Column(name = "body_size_height")
    private String bodySizeHeight;

    @Column(name = "body_size_bust")
    private String bodySizeBust;

    @Column(name = "body_size_waist")
    private String bodySizeWaist;

    @Column(name = "body_size_hips")
    private String bodySizeHips;

    @Column(name = "body_size_girth")
    private String bodySizeGirth;

    @Column(name = "body_size_inseam")
    private String bodySizeInseam;

}

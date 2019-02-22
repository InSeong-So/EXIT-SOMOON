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
@Table(name = "warehouse")
public class Warehouse {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_no")
    private Long warehouseNo;

    @Id
    @Column(name = "warehouse_code")
    private String warehouseCode;

    @Column(name = "warehouse_address")
    private String warehouseAddress;

    @Column(name = "warehouse_contact")
    private String warehouseContact;

    @Column(name = "warehouse_share")
    private String warehouseShare;
}

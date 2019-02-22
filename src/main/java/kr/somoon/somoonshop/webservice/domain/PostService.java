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
@Table(name = "post_service")
public class PostService {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private Long postNo;

    @Id
    @Column(name = "post_service_number")
    private String postServiceNumber;

    @Column(name = "post_service_name")
    private String postServiceName;

    @Column(name = "post_service_contact")
    private String postServiceContact;

    @Column(name = "post_service_address")
    private String postServiceAddress;

    @Column(name = "post_service_postal_code")
    private String postServicePostalCode;

}

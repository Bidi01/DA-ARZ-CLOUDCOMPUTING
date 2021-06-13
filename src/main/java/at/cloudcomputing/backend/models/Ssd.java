package at.cloudcomputing.backend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ssd")
@Getter
@Setter
public class Ssd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idssd")
    int idssd;

    @Column(name = "ss_name")
    String ssdName;

    @Column(name = "ss_storageamount")
    int ssdStorageAmount;

    @Column(name = "ss_price")
    float ssdPrice;
}

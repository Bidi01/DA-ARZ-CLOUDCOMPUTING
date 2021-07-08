package at.cloudcomputing.backend.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hdd")
@Getter
@Setter
public class Hdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhdd")
    int idhdd;

    @Column(name = "h_name")
    String hddname;

    // In Gigabytes
    @Column(name = "h_storageamount")
    int hddstorageamount;

    @Column(name = "h_price")
    float hddprice;


}

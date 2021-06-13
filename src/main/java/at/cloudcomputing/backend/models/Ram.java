package at.cloudcomputing.backend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ram")
@Getter
@Setter
public class Ram{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idram")
    int idram;

    @Column(name = "r_ramname")
    String ramname;

    @Column(name = "r_storageamount")
    int ramstorageamount;

    @Column(name = "r_frequenz")
    String rfrequenz;

    // z.B DDR3 / DDR4
    @Column(name = "r_kind")
    String ramkind;

    @Column(name = "r_price")
    float ramprice;
}

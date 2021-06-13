package at.cloudcomputing.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cpu")
@Getter
@Setter
public class Cpu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcpu")
    int idcpu;

    @Column(name = "c_cpuname")
    String name;

    @Column(name = "c_coreamount")
    int amountofcores;

    @Column(name = "c_frequenz")
    String frequency;

    @Column(name = "c_cache")
    String cache;

    @Column(name = "c_available")
    int available;

    @Column(name = "c_price")
    float price;
}

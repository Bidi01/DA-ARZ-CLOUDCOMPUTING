package at.cloudcomputing.backend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "server")
@Getter
@Setter
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idserver")
    int id;

    @Column(name = "s_premiumservice")
    int serverpremiumservice;

    @OneToMany
    @JoinColumn(name = "idhdd")
    List<Hdd> hddList;

    @OneToMany
    @JoinColumn(name = "idram")
    List<Ram> ramList;

    @OneToMany
    @JoinColumn(name = "idssd")
    List<Ssd> ssdList;

    @OneToMany
    @JoinColumn(name = "idcpu")
    List<Cpu> cpuList;


}

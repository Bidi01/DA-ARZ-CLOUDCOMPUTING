package at.cloudcomputing.backend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "server")
@Getter
@Setter
public class Server {

    @Id
    @GeneratedValue
    @Column(name = "idserver")
    int idserver;

    @Column(name = "s_premiumservice")
    int serverpremiumservice;
}

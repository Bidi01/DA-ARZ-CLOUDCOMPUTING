package at.cloudcomputing.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaddress")
    int id;

    @Column(name = "a_street")
    String street;

    @Column(name = "a_zipcode")
    String plz;

    @Column(name = "a_city")
    String city;

    @Column(name = "a_state")
    String state;

    @Column(name = "a_province")
    String province;

    @Column(name = "a_annotation")
    String annotation;

    @JoinTable(
            name = "address_has_user",
            joinColumns = @JoinColumn(
                    name = "address_idaddress",
                    referencedColumnName = "idaddress"
            )
    )
    @OneToMany
    List<User> users;

}

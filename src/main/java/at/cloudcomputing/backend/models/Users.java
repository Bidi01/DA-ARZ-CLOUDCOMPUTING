package at.cloudcomputing.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "user", schema = "ccomputing")
@Setter
@Getter
public class Users {


    @Id
    @Column(name = "iduser")
    int id;

    @Column(name = "u_email")
    String email;

    @Column(name = "u_firstname")
    String firstName;

    @Column(name = "u_lastname")
    String lastName;

    @Column(name = "u_admin")
    int admin;
}

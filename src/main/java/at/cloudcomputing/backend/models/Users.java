package at.cloudcomputing.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
@Table(name = "user", schema = "ccomputing")
@Setter
@Getter
public class Users {


    @Id
    @GeneratedValue
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

    @Column(name = "u_username")
    String userName;

    @Column(name = "u_password")
    String password;

    @Column(name = "u_active")
    int isactive;

    @Column(name = "u_rolls")
    String userRolls;

    @Column(name = "u_permissions")
    String userPermissions;
}

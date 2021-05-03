package at.cloudcomputing.backend.models;

import jdk.jfr.StackTrace;

import javax.persistence.*;
import java.util.Date;

@Embeddable
@Table(name = "login", schema = "ccomputing")
@Entity
public class Login {

    @Id
    @Column(name = "idlogin")
    int id;

    @Column(name = "loginusername")
    String email;

    @Column(name = "loginpassword")
    String password;

    @Column(name = "registerdate")
    Date registerdate = new Date();

    @Column(name = "logintries")
    int logincount;




}

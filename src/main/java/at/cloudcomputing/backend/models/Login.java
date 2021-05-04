package at.cloudcomputing.backend.models;

import jdk.jfr.StackTrace;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

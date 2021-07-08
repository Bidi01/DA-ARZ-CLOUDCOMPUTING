package at.cloudcomputing.backend.models;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "user", schema = "ccomputing")
@Setter
public class User {

    public User() {
    }

    public User(String email, String firstName, String lastName, String userName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = 0;
        this.userName = userName;
        this.password = password;
        this.isactive = 0;
        this.userRolls = "USER";
        this.userPermissions = "CASUAL_PERMISSION";
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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





    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public int getIsactive() {
        return isactive;
    }

    public List<String> getUserRollsList() {
        if(this.userRolls.length() > 0){
            return Arrays.asList(this.userRolls.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getUserPermissionsList() {
        if(this.userPermissions.length() > 0){
            return Arrays.asList(this.userPermissions.split(","));
        }
        return new ArrayList<>();
    }
}

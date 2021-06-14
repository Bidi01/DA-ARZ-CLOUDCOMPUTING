package at.cloudcomputing.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "user", schema = "ccomputing")
@Setter
public class Users {


    public Users(String email, String firstName, String lastName, int admin, String userName, String password, int isactive, String userRolls, String userPermissions) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.userName = userName;
        this.password = password;
        this.isactive = isactive;
        this.userRolls = userRolls;
        this.userPermissions = userPermissions;
    }

    protected Users() {
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
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

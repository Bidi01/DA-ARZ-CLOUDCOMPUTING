package at.cloudcomputing.backend.models;

import at.cloudcomputing.backend.config.validation.PasswordMatches;
import at.cloudcomputing.backend.config.validation.ValidEmail;
import lombok.Setter;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.util.*;


@PasswordMatches
@Entity
@Table(name = "user", schema = "ccomputing")
@Setter
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    int id;

    @ValidEmail
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

package at.cloudcomputing.backend.models.DTO;

import at.cloudcomputing.backend.config.validation.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @NotEmpty(message = "Email can not be empty")
    @ValidEmail(message = "Please provide a valid email id")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    private String password;

    @NotEmpty(message = "Please confirm your Password")
    private String confirmPassword;

    @NotEmpty(message = "Password can not be empty")
    private String userName;

    private String userRolls = "USER";

    private String userPermissions = "USER";

    private int admin = 0;

    private int isactive = 1;

}

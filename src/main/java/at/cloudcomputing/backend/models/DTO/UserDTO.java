package at.cloudcomputing.backend.models.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserDTO {


    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
            message = "Invalid Password pattern. Password must contain 8 to 20 characters at least one digit, lower, upper case and one special character."
    )
    String password;

    String firstName;

    String lastName;

    String emailAddress;

    String username;
}

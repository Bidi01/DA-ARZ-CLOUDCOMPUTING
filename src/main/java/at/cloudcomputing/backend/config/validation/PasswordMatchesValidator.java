package at.cloudcomputing.backend.config.validation;

import at.cloudcomputing.backend.models.DTO.UserDTO;
import at.cloudcomputing.backend.models.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDTO user = (UserDTO) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
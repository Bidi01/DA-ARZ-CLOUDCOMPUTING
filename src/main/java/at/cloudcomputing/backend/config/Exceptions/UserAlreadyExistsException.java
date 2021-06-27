package at.cloudcomputing.backend.config.Exceptions;

import javax.naming.AuthenticationException;

public class UserAlreadyExistsException extends AuthenticationException {

    public UserAlreadyExistsException(final String msg) {
        super(msg);
    }

}
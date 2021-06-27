package at.cloudcomputing.backend.service;

import at.cloudcomputing.backend.config.Exceptions.UserAlreadyExistsException;
import at.cloudcomputing.backend.models.DTO.UserDTO;
import at.cloudcomputing.backend.models.User;
import at.cloudcomputing.backend.models.UserPrincipalDetails;
import at.cloudcomputing.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;


public interface UserService  {

    void register(final UserDTO user) throws UserAlreadyExistsException;
    boolean checkIfUserExists(final String email);

}
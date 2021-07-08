package at.cloudcomputing.backend.service;

import at.cloudcomputing.backend.models.UserPrincipalDetails;
import at.cloudcomputing.backend.models.User;
import at.cloudcomputing.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserPrincipalDetailsService implements UserDetailsService {
    private  UserRepository userRepository;




    public Optional<User> FindUserById(int id) {
        return  userRepository.findById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =  this.userRepository.findByUserName(s);
        UserPrincipalDetails userPrincipal = new UserPrincipalDetails(user);
        return userPrincipal;
    }


}

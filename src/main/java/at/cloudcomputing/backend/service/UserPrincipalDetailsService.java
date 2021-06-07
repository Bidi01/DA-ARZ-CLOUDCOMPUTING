package at.cloudcomputing.backend.service;

import at.cloudcomputing.backend.models.UserPrincipalDetails;
import at.cloudcomputing.backend.models.Users;
import at.cloudcomputing.backend.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private  UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user =  this.userRepository.findByUserName(s);
        UserPrincipalDetails userPrincipal = new UserPrincipalDetails(user);
        return userPrincipal;
    }
}

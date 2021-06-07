package at.cloudcomputing.backend.models;

import at.cloudcomputing.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserPrincipalDetails implements UserDetails {
    private Users user;
    private UserRepository userRepository;


    public UserPrincipalDetails(Users user) {
        this.user = user;

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.user = userRepository.findById(user.getId()).get();
        if(user.getAdmin() == 1){
        GrantedAuthority  authority = new SimpleGrantedAuthority("ADMIN");
        authorities.add(authority);
            return authorities;
        }else
            return null;


    }

    @Override
    public String getPassword() {
        return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getIsactive() == 1;
    }
}

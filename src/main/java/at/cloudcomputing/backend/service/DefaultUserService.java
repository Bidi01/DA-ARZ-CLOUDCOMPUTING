package at.cloudcomputing.backend.service;

import at.cloudcomputing.backend.config.Exceptions.UserAlreadyExistsException;
import at.cloudcomputing.backend.models.DTO.UserDTO;
import at.cloudcomputing.backend.models.User;
import at.cloudcomputing.backend.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class DefaultUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(UserDTO user) throws UserAlreadyExistsException {
        if(checkIfUserExists(user.getEmail())){
            throw new UserAlreadyExistsException("User already exists for this email");
        }
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExists(String email) {
        return userRepository.findByEmail(email) !=null ? true : false;
    }

    private void encodePassword(User userEntity, UserDTO userDTO){
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    }
}

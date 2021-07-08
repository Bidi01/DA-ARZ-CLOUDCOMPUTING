package at.cloudcomputing.backend.controller;



import at.cloudcomputing.backend.models.User;
import at.cloudcomputing.backend.models.DTO.UserDTO;
import at.cloudcomputing.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {


    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    Logger logger;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        logger = LoggerFactory.getLogger(UserController.class);
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<User> getUserById(@RequestParam(required = true, name = "id")Integer id){
        return userRepository.findById(id);
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody UserDTO userDTO){
            String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
            User user = new User(userDTO.getEmailAddress(), userDTO.getFirstName(),
                    userDTO.getLastName(), userDTO.getUsername(), encodedPassword);
            userRepository.save(user);
            logger.info("User ist created: " + user);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateUser(@RequestParam(required = true, name = "id")Integer id, @RequestBody User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        userRepository.save(user);
        logger.info("User has been updated" + user.getUserName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete")
    public void deleteUserbyId (@RequestParam(required = true, name = "id")Integer id){
        logger.warn("User has been deleted" + userRepository.findById(id));
    }




}

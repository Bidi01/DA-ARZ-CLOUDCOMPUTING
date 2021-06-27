package at.cloudcomputing.backend.controller;


import at.cloudcomputing.backend.models.User;
import at.cloudcomputing.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {


    private final UserRepository userRepository;


    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<User> getUserById(@RequestParam(required = true, name = "id")Integer id){
        return userRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateUser(@RequestParam(required = true, name = "id")Integer id, @RequestBody User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteUserbyId (@RequestParam(required = true, name = "id")Integer id){
       userRepository.deleteById(id);
    }
}

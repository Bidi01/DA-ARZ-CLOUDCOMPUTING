//package at.cloudcomputing.backend.service;
//
//
//import at.cloudcomputing.backend.models.Users;
//import at.cloudcomputing.backend.repositories.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class DBInit implements CommandLineRunner {
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//
//    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) {
//
//        Users test = new Users("test@gmail.com","Felix","Biedermann",1, "TestAdmin",passwordEncoder.encode("testitest"),1, "ADMIN","GRANT_ADMIN");
//        List<Users> users = Arrays.asList(test);
//        this.userRepository.saveAll(users);
//    }
//}
//

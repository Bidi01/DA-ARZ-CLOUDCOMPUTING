package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.config.Exceptions.UserAlreadyExistsException;
import at.cloudcomputing.backend.models.DTO.UserDTO;
import at.cloudcomputing.backend.models.User;
import at.cloudcomputing.backend.service.DefaultUserService;
import at.cloudcomputing.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.net.http.HttpClient;

@Controller
@RequestMapping(value = "")
public class HomeController {

    @Autowired
    private DefaultUserService userService;

    @GetMapping("/login")
    public String login(){return "login";}

    @GetMapping(value = "/register")
    public String register(final Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "register";}

        @PostMapping(value = "/register")
    public String userRegistration(final @Valid UserDTO  userDTO, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userDTO);
            return "register";
        }try {
            userService.register(userDTO);
        }catch (UserAlreadyExistsException e){
            bindingResult.rejectValue("email","userDTO.email","An Account already exists for that email");
            model.addAttribute("registrationForm", userDTO);
            return "register";
        }
    return  "success";
    }


}

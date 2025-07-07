package com.example.userservicejwt.Controller;

import com.example.userservicejwt.DTO.LoginDTO;
import com.example.userservicejwt.DTO.UserRegisterDTO;
import com.example.userservicejwt.DTO.UserRegisterVerifyDTO;
import com.example.userservicejwt.Projections.UserProjection;
import com.example.userservicejwt.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register-init")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO user) {
        ResponseEntity<?> response = userService.registerUser(user);
        if(response.getStatusCode() == HttpStatus.CONFLICT){
            return new ResponseEntity<>("User with this email already exists" , HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Email sent successfully." , HttpStatus.OK);
    }

    @PostMapping("/register-complete")
    public ResponseEntity<?> registerComplete(@RequestBody UserRegisterVerifyDTO user) {
        ResponseEntity<?> response = userService.registerUserComp(user);
        if(response.getStatusCode() != HttpStatus.OK){
            return new ResponseEntity<>("Oops! Something went wrong..." , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response.getBody() , HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO user) {
        ResponseEntity<?> response = userService.login(user);
        if(response.getStatusCode() == HttpStatus.OK){
            return new ResponseEntity<>(response.getBody() , HttpStatus.OK);
        }
        return new ResponseEntity<>("BAD CREDENTIALS" , HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/u")
    public ResponseEntity<UserProjection> getUser(@RequestParam String email){
        ResponseEntity<UserProjection> response = userService.getUser(email);
        if(response.getStatusCode() == HttpStatus.OK) return response;
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

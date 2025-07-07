package com.example.userservicejwt.Service;

import com.example.userservicejwt.DTO.LoginDTO;
import com.example.userservicejwt.DTO.UserRegisterDTO;
import com.example.userservicejwt.DTO.UserRegisterVerifyDTO;
import com.example.userservicejwt.Projections.UserProjection;
import com.example.userservicejwt.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<?> registerUser(UserRegisterDTO userRegisterDTO);
    public ResponseEntity<List<User>> getAllUsers();
    public ResponseEntity<List<User>> getAllActiveUsers();
    public ResponseEntity<String> addRole(String role);
    public ResponseEntity<UserProjection> getUser(String email);
    public ResponseEntity<?> login(LoginDTO user);

    ResponseEntity<?> registerUserComp(UserRegisterVerifyDTO user);
}

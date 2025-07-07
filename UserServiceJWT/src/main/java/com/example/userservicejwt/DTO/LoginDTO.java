package com.example.userservicejwt.DTO;

import com.example.userservicejwt.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String email;
    private String password;
    private Role role;
}

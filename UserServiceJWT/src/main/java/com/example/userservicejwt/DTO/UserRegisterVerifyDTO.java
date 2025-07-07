package com.example.userservicejwt.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterVerifyDTO {
    private String email;
    private String otp;
}

package com.example.articleservice.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
public class UserServiceDTO {
    private String name;
    private String email;
    private List<RoleProjection> roles;
}

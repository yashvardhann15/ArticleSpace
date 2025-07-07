package com.example.userservicejwt.Projections;

import com.example.userservicejwt.models.Role;
import com.example.userservicejwt.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserProjection {
    private String name;
    private String email;
    private List<RoleProjection> roles;

    public static UserProjection makeProjection(User user){
        UserProjection userProjection = new UserProjection();
        userProjection.setName(user.getName());
        userProjection.setEmail(user.getEmail());

        List<RoleProjection> roles = new ArrayList<>();
        Set<Role> r = user.getRoles();

        for(Role role : r){
            RoleProjection roleProjection = new RoleProjection();
            roleProjection = roleProjection.makeRole(role);
            roles.add(roleProjection);
        }

        userProjection.setRoles(roles);
        return userProjection;
    }
}

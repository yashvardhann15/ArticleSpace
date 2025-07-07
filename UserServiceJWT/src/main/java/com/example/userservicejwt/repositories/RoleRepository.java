

package com.example.userservicejwt.repositories;

import com.example.userservicejwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByValue(String value);

    @Override
    Role save(Role role);
}

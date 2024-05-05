package com.guirat.repository;

import com.guirat.entities.User;
import com.guirat.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByRole(UserRole userRole);

    Optional<User> findFirstByEmail(String email);
}

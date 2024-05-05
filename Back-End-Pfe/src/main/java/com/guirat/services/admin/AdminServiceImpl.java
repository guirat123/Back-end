package com.guirat.services.admin;


import com.guirat.entities.User;
import com.guirat.enums.UserRole;
import com.guirat.repository.UserRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostConstruct
    public void creatAdminAccount(){

        User userAccount= userRepository.findByRole(UserRole.ADMIN);
        if(userAccount == null) {
            User admin = new User();
            admin.setEmail("admin@cpt.com");
            admin.setName("admin");
            admin.setRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);
        }


    }
}

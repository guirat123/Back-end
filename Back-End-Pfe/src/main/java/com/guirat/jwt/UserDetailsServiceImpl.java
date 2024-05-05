package com.guirat.services.jwt;

import com.guirat.entities.User;
import com.guirat.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //écrire une logique pour obtenir l'utilisateur de BD
        Optional<User> userOptional=userRepository.findFirstByEmail(email);
        if(userOptional.isEmpty()) throw  new UsernameNotFoundException("Adresse e-mail non trouvée",null);
        return new org.springframework.security.core.userdetails.User(userOptional.get().getEmail(),userOptional.get().getPassword(),new ArrayList<>());

    }
}
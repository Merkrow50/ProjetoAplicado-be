package com.projetoIntegrador.app.config.security;

import com.projetoIntegrador.app.service.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService applicationUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.projetoIntegrador.app.model.auth.User applicationUser = applicationUserService.getByEmail(email);
        return new User(email, applicationUser.getPassword(), new ArrayList<>());
    }
}

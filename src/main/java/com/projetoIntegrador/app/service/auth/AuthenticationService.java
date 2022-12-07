package com.projetoIntegrador.app.service.auth;

import com.projetoIntegrador.app.config.security.JwtTokenUtil;
import com.projetoIntegrador.app.model.auth.User;
import com.projetoIntegrador.app.repository.auth.UserRepository;
import com.projetoIntegrador.app.repository.dto.AuthenticationDTO;
import com.projetoIntegrador.app.repository.dto.LoginDTO;
import com.projetoIntegrador.app.utils.AssertUtil;
import com.projetoIntegrador.app.utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public AuthenticationDTO login(LoginDTO loginDTO) {
        User applicationUser = AssertUtil.found(applicationUserRepository.findOneByEmail(loginDTO.getEmail()), "Usuário não encontrado!");

        if(encoder.matches(loginDTO.getPassword(), applicationUser.getPassword())){
            return new AuthenticationDTO(jwtTokenUtil.generateToken(applicationUser), applicationUser.getId(), applicationUser.getEmail());
        }

        throw new NotFoundException("Usuário ou Senha inválidos!");
    }

}

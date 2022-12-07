package com.projetoIntegrador.app.controller.auth;

import com.projetoIntegrador.app.repository.dto.AuthenticationDTO;
import com.projetoIntegrador.app.repository.dto.LoginDTO;
import com.projetoIntegrador.app.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(path = "/login")
    public AuthenticationDTO login(@RequestBody LoginDTO loginDTO) {
        return authenticationService.login(loginDTO);
    }

}

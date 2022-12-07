package com.projetoIntegrador.app.repository.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private Long userId;
    private String token;
    private String email;

    public AuthenticationDTO(String token, Long userId, String email) {
        this.userId = userId;
        this.token = token;
        this.email = email;
    }

}

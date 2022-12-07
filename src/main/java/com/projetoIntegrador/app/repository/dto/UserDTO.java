package com.projetoIntegrador.app.repository.dto;

import lombok.Data;

@Data
public class UserDTO {

  private Long id;

  private String name;

  private String email;

  private String password;

  private boolean allowsTerms;

}

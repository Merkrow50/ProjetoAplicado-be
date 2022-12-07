package com.projetoIntegrador.app.controller;

import com.projetoIntegrador.app.model.auth.User;
import com.projetoIntegrador.app.repository.dto.AuthenticationDTO;
import com.projetoIntegrador.app.repository.dto.UserDTO;
import com.projetoIntegrador.app.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/users")
@RestController
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping("/create")
  public AuthenticationDTO create(@RequestBody UserDTO user){
    return service.create(user);
  }

  @DeleteMapping("/excluir/{id}")
  public void excluir(@PathVariable Long id) {
    service.delete(id);
  }

  @GetMapping("/listar")
  public List<User> getAll(){
    return service.findAll();
  }

}

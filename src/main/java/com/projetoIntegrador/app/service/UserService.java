package com.projetoIntegrador.app.service;

import com.projetoIntegrador.app.model.auth.User;
import com.projetoIntegrador.app.repository.auth.UserRepository;
import com.projetoIntegrador.app.repository.dto.AuthenticationDTO;
import com.projetoIntegrador.app.repository.dto.LoginDTO;
import com.projetoIntegrador.app.repository.dto.UserDTO;
import com.projetoIntegrador.app.service.auth.AuthenticationService;
import com.projetoIntegrador.app.utils.AssertUtil;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

  private final UserRepository repository;

  private PasswordEncoder passwordEncoder;
  private final ModelMapper modelMapper;

  private AuthenticationService authenticationService;

  public UserService(UserRepository repository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, AuthenticationService authenticationService) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
    this.modelMapper = modelMapper;
    this.authenticationService = authenticationService;
  }

  public User getByEmail(String email){
    return AssertUtil.found(repository.findOneByEmail(email), "User not found with email: " + email);
  }

  public AuthenticationDTO create(UserDTO userDTO){

    Optional<User> existsUser = repository.findOneByEmail(userDTO.getEmail());

    if(existsUser.isPresent()){
      throw new Error("Usuário já existe!");
    }

    User user = new User();

    user.setName(userDTO.getName());
    user.setId(userDTO.getId());
    user.setEmail(userDTO.getEmail());
    user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    user.setAllowsTerms(userDTO.isAllowsTerms());

    repository.save(user);

    var loginDTO = new LoginDTO();
    loginDTO.setEmail(userDTO.getEmail());
    loginDTO.setPassword(userDTO.getPassword());

    return authenticationService.login(loginDTO);
  }

  public List<User> findAll(){
    return repository.findAll();
  }

  public void delete(Long id) {
    Optional<User> camiseta = repository.findById(id);
    camiseta.ifPresent(repository::delete);
  }
}

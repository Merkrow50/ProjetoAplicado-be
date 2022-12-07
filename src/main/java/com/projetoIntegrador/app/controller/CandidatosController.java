package com.projetoIntegrador.app.controller;

import com.projetoIntegrador.app.model.auth.Candidatos;
import com.projetoIntegrador.app.model.auth.User;
import com.projetoIntegrador.app.repository.CandidatosRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/candidatos")
@RestController
public class CandidatosController {

  private final CandidatosRepository repository;

  public CandidatosController(CandidatosRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/listar")
  public List<Candidatos> getAll(){
    return repository.findAll();
  }

}

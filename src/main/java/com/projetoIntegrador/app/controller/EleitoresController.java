package com.projetoIntegrador.app.controller;

import com.projetoIntegrador.app.model.auth.Eleitores;
import com.projetoIntegrador.app.repository.EleitoresRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/eleitores")
@RestController
public class EleitoresController {

  private final EleitoresRepository repository;

  public EleitoresController(EleitoresRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/listar")
  public List<Eleitores> getAll(){
    return repository.findAll();
  }

}

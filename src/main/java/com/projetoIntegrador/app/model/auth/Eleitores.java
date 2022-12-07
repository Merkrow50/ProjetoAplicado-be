package com.projetoIntegrador.app.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Eleitores {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "UF")
  private String UF;

  @Column(name = "Municipio")
  private String municipio;

  @Column(name = "MunicipioBiometrico")
  private String municipioBiometrico;

  @Column(name = "Genero")
  private String genero;

  @Column(name = "Estado Civil")
  private String estadoCivil;

  @Column(name = "Faixa de Idade")
  private String faixaIdade;

  @Column(name = "Escolaridade")
  private String escolaridade;

  @Column(name = "Total de Eleitores")
  private String totalEleitores;

  @Column(name = "Eleitores com Biometria")
  private String eleitoresBiometria;

  @Column(name = "Eleitores Deficientes")
  private String eleitoresDeficientes;

}

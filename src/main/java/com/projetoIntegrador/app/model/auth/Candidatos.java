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
public class Candidatos {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "turno")
  private String turno;

  @Column(name = "estados")
  private String estados;

  @Column(name = "cargo")
  private String cargo;

  @Column(name = "sequencia_candidato")
  private String sequencia_candidato;

  @Column(name = "numero_candidato")
  private String numero_candidato;

  @Column(name = "candidato")
  private String candidato;

  @Column(name = "nome_candidato_urna")
  private String nome_candidato_urna;

  @Column(name = "cpf")
  private String cpf;

  @Column(name = "partido")
  private String partido;

  @Column(name = "nacionalidade")
  private String nacionalidade;

  @Column(name = "nascimento")
  private String nascimento;

  @Column(name = "genero")
  private String genero;

  @Column(name = "escolaridade")
  private String escolaridade;

  @Column(name = "estado_civil")
  private String estado_civil;

  @Column(name = "raca")
  private String raca;

  @Column(name = "ocupacao")
  private String ocupacao;

  @Column(name = "depesa_max")
  private String depesa_max;

  @Column(name = "situacao_turno")
  private String situacao_turno;

  @Column(name = "reeleicao")
  private String reeleicao;

  @Column(name = "declarou_bens")
  private String declarou_bens;

  @Column(name = "destinacao_votos")
  private String destinacao_votos;

  @Column(name = "idade")
  private String idade;

  @Column(name = "faixa_etaria")
  private String faixa_etaria;








}

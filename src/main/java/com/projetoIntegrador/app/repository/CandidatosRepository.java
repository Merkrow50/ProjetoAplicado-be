package com.projetoIntegrador.app.repository;

import com.projetoIntegrador.app.model.auth.Candidatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatosRepository extends JpaRepository<Candidatos, Long> {

}

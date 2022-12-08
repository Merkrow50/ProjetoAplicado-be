package com.projetoIntegrador.app.repository;

import com.projetoIntegrador.app.model.auth.Eleitores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleitoresRepository extends JpaRepository<Eleitores, Long> {

}

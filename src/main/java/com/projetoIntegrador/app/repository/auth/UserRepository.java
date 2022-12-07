package com.projetoIntegrador.app.repository.auth;

import com.projetoIntegrador.app.model.auth.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findOneByEmailAndPassword(String email, String encode);

  Optional<User> findOneByEmail(String email);

}

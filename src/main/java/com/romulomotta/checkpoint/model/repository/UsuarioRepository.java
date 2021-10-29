package com.romulomotta.checkpoint.model.repository;

import com.romulomotta.checkpoint.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername (String username);
}

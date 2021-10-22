package com.romulomotta.checkpoint.model.repository;

import com.romulomotta.checkpoint.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
}

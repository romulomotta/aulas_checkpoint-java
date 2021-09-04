package com.romulomotta.checkpoint.model.repository;

import com.romulomotta.checkpoint.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

package com.romulomotta.checkpoint.model.repository;

import com.romulomotta.checkpoint.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}

package com.romulomotta.checkpoint.model.repository;

import com.romulomotta.checkpoint.model.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {
}

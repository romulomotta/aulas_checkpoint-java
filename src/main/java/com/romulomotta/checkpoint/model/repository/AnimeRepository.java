package com.romulomotta.checkpoint.model.repository;

import com.romulomotta.checkpoint.model.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {

    @Query(value = "SELECT * FROM ANIME ORDER BY ID DESC LIMIT 2", nativeQuery = true)
    List<Anime> find2LastAnime();
}

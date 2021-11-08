package com.romulomotta.checkpoint.rest;

import com.romulomotta.checkpoint.model.entity.Anime;
import com.romulomotta.checkpoint.model.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/animes")
public class AnimeController {

    private AnimeRepository repository;

    public AnimeController(AnimeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Anime> getAll() {
        return repository.findAll();
    }

    @GetMapping("last")
    public List<Anime> getLastTwo() {
        return repository.find2LastAnime();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Anime save(@RequestBody @Valid Anime anime) {
        return repository.save(anime);
    }

    @GetMapping("{id}")
    public Anime findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.findById(id)
                .map( anime -> {
                    repository.delete(anime);
                    return anime;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Anime animeAtualizado) {
        repository.findById(id)
                .map( anime -> {
                    anime.setTitle(animeAtualizado.getTitle());
                    anime.setEpisode(animeAtualizado.getEpisode());
                    anime.setSeason(animeAtualizado.getSeason());
                    return repository.save(anime);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

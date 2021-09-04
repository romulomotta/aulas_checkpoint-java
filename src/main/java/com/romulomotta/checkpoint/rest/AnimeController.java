package com.romulomotta.checkpoint.rest;

import com.romulomotta.checkpoint.model.entity.Anime;
import com.romulomotta.checkpoint.model.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/animes")
@CrossOrigin("http://localhost:4200")
public class AnimeController {

    private AnimeRepository repository;

    public AnimeController(AnimeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Anime> getAll() {
        return repository.findAll();
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

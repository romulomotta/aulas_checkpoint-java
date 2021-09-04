package com.romulomotta.checkpoint.rest;

import com.romulomotta.checkpoint.model.entity.Cliente;
import com.romulomotta.checkpoint.model.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    private ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.findById(id)
                .map( cliente -> {
                    repository.delete(cliente);
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Cliente clienteAtualizado) {
        repository.findById(id)
                .map( cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    return repository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

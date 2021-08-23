package com.github.maiconwps.citiesapi.resources;

import com.github.maiconwps.citiesapi.entities.State;
import com.github.maiconwps.citiesapi.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {

    @Autowired
    private StateRepository repository;

    @GetMapping
    public Page<State> listAll(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<State> optionalState = repository.findById(id);

        if (optionalState.isPresent()){
            return ResponseEntity.ok().body(optionalState.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

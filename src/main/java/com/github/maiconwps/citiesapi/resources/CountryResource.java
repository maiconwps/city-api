package com.github.maiconwps.citiesapi.resources;

import com.github.maiconwps.citiesapi.entities.Country;
import com.github.maiconwps.citiesapi.repositories.CountryRepository;
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
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> listAll(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optionalCountry = repository.findById(id);

        if (optionalCountry.isPresent()){
            return ResponseEntity.ok().body(optionalCountry.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

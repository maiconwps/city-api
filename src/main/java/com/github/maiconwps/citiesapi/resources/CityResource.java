package com.github.maiconwps.citiesapi.resources;

import com.github.maiconwps.citiesapi.entities.City;
import com.github.maiconwps.citiesapi.repositories.CityRepository;
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
@RequestMapping("/cities")
public class CityResource {

    @Autowired
    private CityRepository repository;

    @GetMapping
    public Page<City> listAll(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<City> optionalCity = repository.findById(id);

        if (optionalCity.isPresent()){
            return ResponseEntity.ok().body(optionalCity.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

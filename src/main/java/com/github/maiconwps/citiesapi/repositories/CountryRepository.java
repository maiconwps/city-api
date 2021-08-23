package com.github.maiconwps.citiesapi.repositories;

import com.github.maiconwps.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

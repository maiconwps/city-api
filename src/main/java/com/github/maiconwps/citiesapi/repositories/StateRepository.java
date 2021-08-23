package com.github.maiconwps.citiesapi.repositories;

import com.github.maiconwps.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}

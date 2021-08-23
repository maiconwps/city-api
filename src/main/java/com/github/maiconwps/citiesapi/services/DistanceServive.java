package com.github.maiconwps.citiesapi.services;

import com.github.maiconwps.citiesapi.entities.City;
import com.github.maiconwps.citiesapi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DistanceServive {
    @Autowired
    private CityRepository cityRepository;

    public double distanceByPointsInMiles(Long citiId1, Long citiId2) {
        return cityRepository.distanceByPoints(citiId1, citiId2);
    }

    public double distanceByCubeInMeters(Long citiId1, Long citiId2) {
        List<City> cities = cityRepository.findAllById(Arrays.asList(citiId1, citiId2));

        Point p1 = cities.get(0).getGeolocation();
        Point p2 = cities.get(1).getGeolocation();

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}

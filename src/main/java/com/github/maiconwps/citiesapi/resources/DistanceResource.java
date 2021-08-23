package com.github.maiconwps.citiesapi.resources;

import com.github.maiconwps.citiesapi.services.DistanceServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    @Autowired
    private DistanceServive service;

    @GetMapping("/by-points")
    public double calculateDistanceByPoints(@RequestParam(name = "from") Long citiId1,
                                           @RequestParam(name = "to") Long citiId2){
        return service.distanceByPointsInMiles(citiId1, citiId2);
    }

    @GetMapping("/by-cube")
    public double calculateDistanceByCube(@RequestParam(name = "from") Long citiId1,
                                            @RequestParam(name = "to") Long citiId2){

        return service.distanceByCubeInMeters(citiId1, citiId2);
    }
}

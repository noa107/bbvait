package com.bbvait.weather.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbvait.weather.service.dao.entity.City;
import com.bbvait.weather.service.dao.repository.CityRepository;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping
    public List<City> getcities() {
        return cityRepository.findAll();
    }
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id) {
        return cityRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping
    public ResponseEntity createCity(@RequestBody City city) throws URISyntaxException {
        City savedCity = cityRepository.save(city);
        return ResponseEntity.created(new URI("/cities/" + savedCity.getId())).body(savedCity);
    }
    @CrossOrigin(origins="http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity updateCity(@PathVariable Long id, @RequestBody City city) {
        City currentCity = cityRepository.findById(id).orElseThrow(RuntimeException::new);
        currentCity.setName(city.getName());
        currentCity = cityRepository.save(currentCity);

        return ResponseEntity.ok(currentCity);
    }
    @CrossOrigin(origins="http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable Long id) {
        cityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

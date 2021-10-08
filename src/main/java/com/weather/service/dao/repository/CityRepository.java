package com.weather.service.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.weather.service.dao.entity.City;

public interface CityRepository extends MongoRepository<City, Long> {
}
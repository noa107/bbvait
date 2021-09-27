package com.bbvait.weather.service.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbvait.weather.service.dao.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
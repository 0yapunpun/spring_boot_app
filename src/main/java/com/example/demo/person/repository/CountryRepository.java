package com.example.demo.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.person.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}

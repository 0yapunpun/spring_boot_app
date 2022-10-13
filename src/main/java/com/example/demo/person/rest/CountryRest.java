package com.example.demo.person.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.person.model.Country;
import com.example.demo.person.service.CountryService;

@RestController
@RequestMapping("/country/")
public class CountryRest {

	@Autowired
	private CountryService countryService;

	@GetMapping
	private ResponseEntity<List<Country>> getAllCountries() {
		return ResponseEntity.ok(countryService.findAll());
	}

}

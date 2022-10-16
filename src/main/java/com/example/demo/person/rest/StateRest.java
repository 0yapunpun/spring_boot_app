package com.example.demo.person.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.person.model.State;
import com.example.demo.person.service.StateService;

@RestController
@RequestMapping ("/state/")
public class StateRest {

	@Autowired
	private StateService stateService;
	
	@GetMapping("{id}")
	private ResponseEntity<List<State>> getStateByCountry (@PathVariable("id") Long idCountry){
		return ResponseEntity.ok(stateService.findByIdCountry(idCountry));
	}
	
}

package com.example.demo.person.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.person.model.Person;
import com.example.demo.person.service.PersonService;

@RestController
@RequestMapping("/persons/")
public class PersonRest {
	
	@Autowired
	private PersonService personService;

	@GetMapping
	private ResponseEntity<List<Person>> getAllUsers(){
		return ResponseEntity.ok(personService.findAll());
	}	
	
	@PostMapping
	private ResponseEntity<Person> savePerson (@RequestBody Person person){
		Person personSaved = personService.save(person);
		
		try {			
			return ResponseEntity.created(new URI("/person/"+personSaved.getId())).body(personSaved);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deletePerson(@PathVariable ("id") Long id){
		personService.deleteById(id);
		return ResponseEntity.ok((personService.findById(id) != null));
	};
}

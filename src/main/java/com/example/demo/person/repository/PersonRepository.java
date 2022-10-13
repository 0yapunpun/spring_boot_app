package com.example.demo.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}

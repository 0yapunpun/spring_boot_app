package com.example.demo.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.person.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

}

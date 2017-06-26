package com.personal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.demo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    List<Person> findByName(String name);
    
    List<Person> findAll();
    
}

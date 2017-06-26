package com.personal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.demo.entity.Person;
import com.personal.demo.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    public void add(Person p) {
	personRepository.save(p);
    }
    
    public void delete(Person p) {
	personRepository.delete(p);
    }
    
    public void delete(Long id) {
	personRepository.delete(id);
    }
    
    public List<Person> getList() {
	return personRepository.findAll();
    }
    
    public List<Person> findByName(String name) {
	return personRepository.findByName(name);
    }
    
    public Person findById(long id) {
	return personRepository.findOne(id);
    }
} 

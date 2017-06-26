package com.personal.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.personal.demo.entity.Person;
import com.personal.demo.repository.AdminRepository;
import com.personal.demo.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalApplicationTests {

    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Test
    public void contextLoads() {
//	Person p = new Person();
//	p.setAge(20);
//	p.setEmail("1@qq.com");
//	p.setHobby("1");
//	p.setName("ac");
//	p.setNumber("123456");
//	p.setSex("男");
//	personRepository.save(p);
	System.out.println(System.getProperty("user.dir").replace('\\', '/'));
    }

}

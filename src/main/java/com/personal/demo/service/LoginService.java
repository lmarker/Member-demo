package com.personal.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.personal.demo.repository.AdminRepository;

@Component
public class LoginService {

    @Autowired private AdminRepository adminRepository;
    
    public boolean login(String username,String password) {
	return adminRepository.login(username, password)!=null;
    }
    
}

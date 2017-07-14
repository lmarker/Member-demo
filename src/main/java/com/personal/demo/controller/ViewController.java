package com.personal.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.personal.demo.entity.Person;
import com.personal.demo.service.LoginService;
import com.personal.demo.service.PersonService;

@Controller
public class ViewController {

    private static final String DEFAULT_USER = "none";
    
    @Autowired private LoginService loginService;
    
    @Autowired private PersonService personService;

    @RequestMapping("/person")
    public ModelAndView login(@RequestParam("username") String username,@RequestParam("password")String password) {
	if(loginService.login(username, password)) {
	    return new ModelAndView("redirect:/index");
	} else {
	    return new ModelAndView("redirect:/login");
	}

    }
    
    @RequestMapping("/person/insert")
    public String login(Model model) {
	model.addAttribute("person", new Person());
	return "home";
    }

    @RequestMapping("/index")
    public String hello(Model model) {
	Subject sub = SecurityUtils.getSubject();
	String username;
	if(sub==null || sub.getPrincipals() == null) {
	    username = DEFAULT_USER;
	}
	username = (String)sub.getPrincipals().getPrimaryPrincipal();
	model.addAttribute("list",personService.getList());
	model.addAttribute("user", username);
	return "list";
    }
    
    @RequestMapping("/info")
    public String detail() {
	return "info";
    }
    
}

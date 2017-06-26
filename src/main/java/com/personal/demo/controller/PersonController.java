package com.personal.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.personal.demo.entity.Person;
import com.personal.demo.service.PersonService;
import com.personal.demo.tool.FTPUtil;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/save",method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Person person,@RequestParam("path") MultipartFile file,Model model) {
	String success="";
	try {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    String name = file.getOriginalFilename();
	    String fileName = sdf.format(new Date())+name.substring(name.lastIndexOf('.'));
	    if(FTPUtil.uploadPicture(fileName, file.getInputStream())) {
		success=fileName;
	    }
	} catch (IllegalStateException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	if(success.length()<2) {
	    person.setUrl("default.svg");
	} else
	    person.setUrl(success);
	personService.add(person);
	model.addAttribute("person",person);
	return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value="/list")
    public List<Person> persons() {
	return personService.getList();
    }

    @RequestMapping(value="delete")
    public ModelAndView delete(@RequestParam("id") long id) {
	personService.delete(id);
	return new ModelAndView("redirect:/index");
    }

}

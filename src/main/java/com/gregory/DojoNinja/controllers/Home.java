package com.gregory.DojoNinja.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gregory.DojoNinja.models.Dojo;
import com.gregory.DojoNinja.models.Ninja;
import com.gregory.DojoNinja.services.DojoService;
import com.gregory.DojoNinja.services.NinjaService;

@Controller
public class Home {
	private DojoService dojoService;
	private NinjaService ninjaService;
	
	public Home(DojoService dojoService, NinjaService ninjaService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	
	
	@RequestMapping("/")
	public String index(Model model) {
		
		return "index.jsp";
	}
	
	@RequestMapping("/newdojo")
	public String newdojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "newdojo.jsp";
	}
	
	@PostMapping("/newdojoform")
	public String newdojoform( @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}else {
			System.out.println(dojo.getName());
			
			dojoService.addDojo(dojo);
			return "index.jsp";
		}
		
	}
	
	
	
	
	@RequestMapping("/newninja")
	public String newninja(@ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		
		
		return "newninja.jsp";
	}
	
	@PostMapping("/newninjaform")
	public String newninjaform( @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
		
			return "newninja.jsp";
		}else {
			
			ninjaService.addNinja(ninja);
			return "redirect:/";
		}
	}	
	
	@RequestMapping("/dojo/{id}")
	public String dojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojoById(id);
		
		model.addAttribute("dojo", dojo);
		
		return "dojo.jsp";
	}
}

package com.gregory.DojoNinja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gregory.DojoNinja.models.Dojo;
import com.gregory.DojoNinja.repository.DojoRepository;

@Service
public class DojoService {
	
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return (List<Dojo>) dojoRepository.findAll();
	}
	public Dojo findDojoById(Long id) {
		Dojo dojo = dojoRepository.findOne(id);
		return dojo;
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}

	public DojoRepository getDojoRepository() {
		return dojoRepository;
	}


	
	
}

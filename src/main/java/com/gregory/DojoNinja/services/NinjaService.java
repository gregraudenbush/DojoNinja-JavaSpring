package com.gregory.DojoNinja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gregory.DojoNinja.models.Ninja;
import com.gregory.DojoNinja.repository.NinjaRepository;

@Service 
public class NinjaService {
	
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return (List<Ninja>) ninjaRepository.findAll();
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}

	public NinjaRepository getNinjaRepository() {
		return ninjaRepository;
	}

	public void setNinjaRepository(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	
}

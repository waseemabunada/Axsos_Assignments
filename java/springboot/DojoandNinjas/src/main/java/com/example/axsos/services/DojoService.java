package com.example.axsos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.axsos.models.Dojo;
import com.example.axsos.repositories.DojoRepository;

@Service
	public class DojoService {
		    @Autowired
		    private DojoRepository dojoRepo;
	 
		    public Dojo createDojo(Dojo dojd) {
		        return dojoRepo.save(dojd);
		    }
		    
	 
		    public Dojo findDojo(Long id) {
		        return dojoRepo.findById(id).orElse(null);
		    }


		    public List<Dojo> findAllDojos() {
		        return  dojoRepo.findAll();
		 	}
	
		}
	 
	


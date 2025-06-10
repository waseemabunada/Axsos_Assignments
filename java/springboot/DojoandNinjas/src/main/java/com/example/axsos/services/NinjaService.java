package com.example.axsos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.axsos.models.Ninja;
import com.example.axsos.repositories.NinjaRepository;

@Service
public class NinjaService {
 
 
    @Autowired
    private NinjaRepository ninjaRepo;
 
    public List<Ninja> findAllNinjas() {
        return ninjaRepo.findAll();
    }
 
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepo.save(ninja);
    }
 
    public Ninja findNinja(Long id) {
        return ninjaRepo.findById(id).orElse(null);
    }

    
}
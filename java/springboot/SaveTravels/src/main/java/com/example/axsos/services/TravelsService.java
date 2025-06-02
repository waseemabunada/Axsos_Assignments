package com.example.axsos.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.axsos.models.Travels;
import com.example.axsos.repositories.TravelsRepository;

import jakarta.validation.Valid;

@Service
public class TravelsService {
	 @Autowired
	 TravelsRepository travelsRepository;

	public List<Travels> allTravels() {
       return  travelsRepository.findAll();
	}
	
	
	   public Travels createTravels(Travels travels) {
           return travelsRepository.save(travels);
       }


     public Travels findTravels(Long id) {
           Optional<Travels> optionalTravels = travelsRepository.findById(id);
           if(optionalTravels.isPresent()) {
               return optionalTravels.get();
           } else {
               return null;
           }
     }
     
     public Travels updateTravels(Travels travels) {
	        return travelsRepository.save(travels);
	    }

     public void deletetravel(Long id) {
    	   travelsRepository.deleteById(id);
     }

}

	
	

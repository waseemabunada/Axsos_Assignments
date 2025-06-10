package com.example.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.axsos.models.Dorm;
import com.example.axsos.repositories.DormRepository;

@Service
public class DormService {
	@Autowired
	private DormRepository dormRepositories;

	public Dorm createDorm(Dorm dorm) {
		return dormRepositories.save(dorm);
	}
	@Transactional
	public Dorm findDorm(Long id) {
		return dormRepositories.findById(id).orElse(null);
	}

	public List<Dorm> findAllDorms() {
		return dormRepositories.findAll();
	}

	public void deleteStudent(Long id) {
		Optional<Dorm> optionalDorm = dormRepositories.findById(id);
		if (optionalDorm.isPresent()) {
			dormRepositories.deleteById(id);
		}

	}
	
		}
	 
	


package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.duckdemo.data.model.Duck;
import com.example.duckdemo.dto.DuckDTO;
import com.example.duckdemo.exceptions.DuckNotFoundException;

@Service
public class PhoneBookService {
	
	private PhoneRepository phoneRepository;
	
	private PhoneMapper phoneMapper;
	
	@Autowired
	public phoneService(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
		this.phoneRepository = phoneRepository;
		this.phoneMapper = phoneMapper;
	}
	
	public List<PhoneDTO> readAllPhones() {
		
	}
	
	public PhoneDTO readById(Integer id) {
		
	}
	
	public PhoneDTO readByName(String name) {
		
	}
	
	public PhoneDTO createPhone(Phone phone) {
		
	}
	
	public PhoneDTO updatePhone(Integer id, Phone phone) throws EntityNotFoundException {
		
	}
	
	public boolean deletePhone(Integer id) {
		
	}
}

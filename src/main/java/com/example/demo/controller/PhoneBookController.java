package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.duckdemo.data.model.Duck;
import com.example.duckdemo.dto.DuckDTO;



@RestController
@RequestMapping(path = "/phonebook")
public class PhoneBookController {
	
	private PhoneBookService phoneBookService;
	
	@Autowired
	public PhoneBookController(PhoneBookService phoneBookService) {
		this.phoneBookService = phoneBookService;
	}

	@GetMapping
	public ResponseEntity<PhoneDTO> getAllContacts(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "1442");
		
		List<PhoneDTO> data = phoneBookService.readAllPhones();
		
		return new ResponseEntity<List<PhoneDTO>>(data, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PhoneDTO> getContactById(@PathVariable("id") int id) {
	
		PhoneDTO phone = phoneBookService.readById(id);
		
		
		return new ResponseEntity<PhoneDTO>(phone, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PhoneDTO> createDuck(@Valid @RequestBody PhoneBook phoneBook) {
		// A Duck is retrieved from the incoming request body (the conversion from json to duck is automatic)
		// - `@RequestBody Duck duck` makes this happen
		// - @Valid is used to employ our models validation on the incoming request
		
		PhoneDTO newPhone = phoneBookService.createDuck(phoneBook);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newPhone.getId()));
	
		return new ResponseEntity<PhoneDTO>(newPhone, headers, HttpStatus.CREATED);
	}
}

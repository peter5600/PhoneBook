package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PhoneBookDTO;
import com.example.demo.model.Phone;
import com.example.demo.services.PhoneBookService;





@RestController
@RequestMapping(path = "/phonebook")
public class PhoneBookController {
	
	private PhoneBookService phoneBookService;
	
	@Autowired
	public PhoneBookController(PhoneBookService phoneBookService) {
		this.phoneBookService = phoneBookService;
	}

	@GetMapping
	public ResponseEntity<List<PhoneBookDTO>> getAllContacts(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "1442");
		
		List<PhoneBookDTO> data = phoneBookService.readAllPhones();
		
		return new ResponseEntity<List<PhoneBookDTO>>(data, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PhoneBookDTO> getContactById(@PathVariable("id") int id) {
	
		PhoneDTO phone = phoneBookService.readById(id);
		
		
		return new ResponseEntity<PhoneBookDTO>(phone, HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<PhoneBookDTO> getDuckByName(@PathVariable("name") String name) {
		PhoneDTO phone = phoneBookService.readByName(name);
		
		return new ResponseEntity<PhoneDTO>(phone, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PhoneBookDTO> createPhone(@Valid @RequestBody Phone phone) {

		
		PhoneDTO newPhone = phoneBookService.createPhone(phone);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newPhone.getId()));
	
		return new ResponseEntity<PhoneBookDTO>(newPhone, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PhoneBookDTO> updatePhone(@PathVariable("id") int id,
										   @RequestBody Phone phone) {
		PhoneDTO updatedPhone = phoneBookService.updatePhone(id, phone);
		
		return new ResponseEntity<PhoneBookDTO>(updatedPhone, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePhone(@PathVariable("id") int id) {		
		return new ResponseEntity<Boolean>(phoneBookService.deletePhone(id), HttpStatus.OK);
	}
}

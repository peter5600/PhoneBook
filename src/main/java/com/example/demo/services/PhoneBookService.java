package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.repository.PhoneRepository;
import com.example.demo.dto.PhoneBookDTO;
import com.example.demo.mappers.PhoneMapper;
import com.example.demo.model.Phone;

import javassist.NotFoundException;


@Service
public class PhoneBookService {
	
	private PhoneRepository phoneRepository;
	
	private PhoneMapper phoneMapper;
	
	@Autowired
	public PhoneBookService(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
		this.phoneRepository = phoneRepository;
		this.phoneMapper = phoneMapper;
	}
	
	public List<PhoneBookDTO> readAllPhones() {
		List<Phone> phones = phoneRepository.findAll();
		List<PhoneBookDTO> PhoneDtoList = new ArrayList<PhoneBookDTO>();
		
		for(Phone p : phones) {
			PhoneDtoList.add(phoneMapper.mapToDTO(p));
		}
		return PhoneDtoList;
	}
	
	public PhoneBookDTO readById(Integer id) throws NotFoundException {
		Optional<Phone> phone = phoneRepository.findById(id);
		if(phone.isPresent()) {
			return phoneMapper.mapToDTO(phone.get());
		}else {
			throw new NotFoundException("Can't find the phone by that id");
		}
	}
	
	public PhoneBookDTO readByName(String fname, String lname) {
		Phone phone = phoneRepository.getPhoneNumberByName(fname,lname);
		
		return phoneMapper.mapToDTO(phone);
	}
	
	public PhoneBookDTO createPhone(Phone phone) {
		Phone createdPhone = phoneRepository.save(phone);
		
		return phoneMapper.mapToDTO(createdPhone);
	}
	
	public PhoneBookDTO updatePhone(Integer id, Phone phone) throws EntityNotFoundException, NotFoundException {
		Optional<Phone> foundPhone = phoneRepository.findById(id);
		Phone newPhone;
		
		if (foundPhone.isPresent()) {
			newPhone = foundPhone.get();
		} else {
			throw new NotFoundException("Can't update it dosen't exist");
		}
		
		newPhone.setFirst_name(phone.getFirst_name());
		newPhone.setLast_name(phone.getLast_name());
		newPhone.setNumber(phone.getNumber());
		
		Phone savedPhone = phoneRepository.save(newPhone);
		
		return phoneMapper.mapToDTO(savedPhone);
	}
	
	public boolean deletePhone(Integer id) throws NotFoundException {
		if (!phoneRepository.existsById(id)) {
			throw new NotFoundException("Cant find this");
		}
		phoneRepository.deleteById(id);
		
		return !phoneRepository.existsById(id);
	}
}

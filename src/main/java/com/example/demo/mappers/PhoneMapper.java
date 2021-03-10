package com.example.demo.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.PhoneBookDTO;
import com.example.demo.model.Phone;



public class PhoneMapper {

private ModelMapper modelMapper;
	
	@Autowired
	public PhoneMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public PhoneBookDTO mapToDTO(Phone phone) {
		return this.modelMapper.map(phone, PhoneBookDTO.class);
	}
	
	public Phone mapToPhone(PhoneBookDTO phoneDTO) {
		return this.modelMapper.map(phoneDTO, Phone.class);
	}
}

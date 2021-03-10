package com.example.demo.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;



public class PhoneMapper {

private ModelMapper modelMapper;
	
	@Autowired
	public PhoneMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public PhoneDTO mapToDTO(Phone phone) {
		return this.modelMapper.map(phone, PhoneDTO.class);
	}
	
	public phone mapToPhone(PhoneDTO phoneDTO) {
		return this.modelMapper.map(phoneDTO, phone.class);
	}
}

package com.example.demo.data.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	
	//Derived Query
	public Phone findByName(String firstName, String LastName);
	
	
	@Query(value = "SELECT * FROM phone_book", nativeQuery = true)
	public List<Phone> getAllPhoneNumbers();
	
	@Query("SELECT * FROM phone_book WHERE phone_book.first_name = ?1 and phone_book.last_name = ?1")
	public Phone getPhoneNumberByName();
	
	@Query("SELECT * FROM phone_book WHERE id = ?1")
	public Phone getPhoneNumberByID();
}

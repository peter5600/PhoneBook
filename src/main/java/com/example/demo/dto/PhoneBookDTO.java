package com.example.demo.dto;

public class PhoneBookDTO {
	private int id;
	private String fname;
	private String lname;
	private String PhoneNumber;
	private String BusinessNumber;
	
	
	public PhoneBookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PhoneBookDTO(int id, String fname, String lname, String phoneNumber) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		PhoneNumber = phoneNumber;
	}



	public PhoneBookDTO(int id, String fname, String lname, String phoneNumber, String businessNumber) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.PhoneNumber = phoneNumber;
		this.BusinessNumber = businessNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	public String getBusinessNumber() {
		return BusinessNumber;
	}


	public void setBusinessNumber(String businessNumber) {
		BusinessNumber = businessNumber;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BusinessNumber == null) ? 0 : BusinessNumber.hashCode());
		result = prime * result + ((PhoneNumber == null) ? 0 : PhoneNumber.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneBookDTO other = (PhoneBookDTO) obj;
		if (BusinessNumber == null) {
			if (other.BusinessNumber != null)
				return false;
		} else if (!BusinessNumber.equals(other.BusinessNumber))
			return false;
		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}
	
}

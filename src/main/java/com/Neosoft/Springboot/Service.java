package com.Neosoft.Springboot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private EmployeeRepositry employeerepo ;
	
	
	public void save(Employee employe) {
		employeerepo.save(employe);
	}
	
	 public void update (Employee employee) {
		 employeerepo.save(employee);
	 }
	
	public void delete (Integer id) {
		employeerepo.deleteById(id);
	}
	
	public List<Employee> sortbyname (String name, String surname) {
	return employeerepo.findByNameOrSurname(name, surname);
	}
	
   public List<Employee> sortbypincode(String namee, Integer pincode){
	return employeerepo.findByNameOrPincode(namee, pincode);
	
}
   public List<Employee>sortbydob (Date dob,Date doj){
	return employeerepo.findByDobAndDoj(dob, doj);
	   
   }
	
	
}
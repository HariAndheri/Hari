package com.Neosoft.Springboot;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {

	public abstract List<Employee> findByNameOrSurname(String name, String surname);

	public abstract List<Employee> findByNameOrPincode(String namee, Integer pincode);
	
	public abstract List<Employee> findByDobAndDoj(Date dob,Date doj);
}

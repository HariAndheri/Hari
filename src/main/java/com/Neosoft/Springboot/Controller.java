package com.Neosoft.Springboot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private Service service;
	
	
	@PostMapping("register")
	public ResponseEntity<Employee> register(@RequestBody Employee employ){
		service.save(employ);
		
		return new  ResponseEntity<Employee>(employ,HttpStatus.CREATED);		
	}	
	
	@PutMapping("update")
	public ResponseEntity<Employee> update (@RequestBody Employee empl){
		service.update(empl);
		return new ResponseEntity<Employee>(empl,HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Employee> delete(@RequestParam Integer id){
		service.delete(id);
		return new ResponseEntity<Employee> (HttpStatus.OK);
	}
	
	@GetMapping("getbyname/{name}/{surname}")
	public ResponseEntity<List<Employee>> getbyname (@PathVariable String name, String surname){
		List<Employee> emps = service.sortbyname(name, surname);
		return new ResponseEntity<List<Employee>> (emps,HttpStatus.OK);		
	}
	
	@GetMapping("getbypincode/{name}/{pincode}")
	public ResponseEntity<List<Employee>>getbypincode (@PathVariable String name, Integer pincode){
	List<Employee> pin = service.sortbypincode(name, pincode);
	return new ResponseEntity<List<Employee>> (pin,HttpStatus.OK);
				
	}

	@GetMapping("getbydob/{dob}/{doj}")
	public ResponseEntity<List<Employee>> getbydob(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date doj){
	List<Employee>dobirth=	service.sortbydob(dob, doj);
	return new ResponseEntity<List<Employee>>(dobirth,HttpStatus.OK);
	}
	
}

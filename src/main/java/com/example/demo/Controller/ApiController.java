package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Child;
import com.example.demo.Service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService a;
	
	@GetMapping("/get")
	public List<Child> showDetails(){
		return a.getDetails();
	}
	
	@PostMapping("/post")
	public String addDetails(@RequestBody Child c) {
		a.add(c);
		return "Added babyId "+c.getBabyId();
	}
	
	@GetMapping("product/{field}")
	public List<Child> getWithSort(@PathVariable String field){
		return a.getSorted(field);
	}
	
	@GetMapping("/product/{offset}/{pageSize}")
	public List<Child> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		return a.getWithPagination(offset, pageSize);
	}
	
	@PutMapping("/updateDetails")
	public Child updateInfo(@RequestBody Child c1)
	{
		return a.updateDetails(c1);
	}
	@DeleteMapping("/deleteDetails/{babyId}")
	public String deleteInfo(@PathVariable("babyId") int babyId)
	{
		a.deleteDetails(babyId);
		return "Deleted the Element";
	}
}

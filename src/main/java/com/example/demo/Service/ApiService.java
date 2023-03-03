package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Child;
import com.example.demo.Repository.ChildRepo;

@Service
public class ApiService {
	@Autowired
	ChildRepo cRepo;
	
	public String add(Child c) {
		cRepo.save(c);
		return "Added";
	}
	public List<Child> getDetails(){
		return cRepo.findAll();
	}
	public List<Child> getSorted(String field){
		return cRepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Child> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Child> page =cRepo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	
	public Child updateDetails(Child b1)
	{
		return cRepo.saveAndFlush(b1);
	}
	public void deleteDetails(int id)
	{
		cRepo.deleteById(id);
	}
}

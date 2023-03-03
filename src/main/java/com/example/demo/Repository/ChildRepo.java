package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Child;

@Repository
public interface ChildRepo extends JpaRepository<Child, Integer>{

}

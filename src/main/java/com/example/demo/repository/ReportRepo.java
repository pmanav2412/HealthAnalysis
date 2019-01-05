package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Exercise;
import com.example.demo.model.Report;

@Repository
public interface ReportRepo extends CrudRepository<Report,Integer> {

	 public List<Report> findByName(String u);
}

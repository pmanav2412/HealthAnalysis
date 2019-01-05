package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise,Integer> {
  public  List<Exercise> findAll();
  public List<Exercise> findByUname(String u);

}

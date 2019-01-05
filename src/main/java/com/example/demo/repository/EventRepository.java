

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
	
public  Event findByEventid(int eventid);	
public  Event findByEventname(String eventname);	

@Modifying
@Transactional
@Query("SELECT u.eventname  from Event u ")
 public List<String> user123();


}

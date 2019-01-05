

package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class EventService {
	
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository=eventRepository;
	}
	
	public void saveMyEvent(Event event)
	{
		eventRepository.save(event);
	}
	
	public List<Event> showAllEvents(){
		List<Event> events = new ArrayList<Event>();
	for(Event event :eventRepository.findAll()) {
		events.add(event);
	}
		
		return events;
	}
	

	
	
	
	
	
	public List<Event> showAllcheck(String  s){
		System.out.println(s);
		Event e3=null;
		String s1[]= s.split("/");
	//	System.out.println("String list"+s1);
		List<String> e1 = new ArrayList<String>();
		List<Event> events = new ArrayList<Event>();
	e1=eventRepository.user123();
	System.out.println(e1);
	for(String event1 :s1) {
		
		if(e1.contains(event1))
		{
     e3=eventRepository.findByEventname(event1);
	   events.add(e3);
		}
		//e1.add(event1);
	}	
		
		return events;
	}
	
	
	
	
	
	public void deleteMyevent(int eventid) {
		
		eventRepository.delete(eventid);
	}
	
public Event editEvent(int eventid) {
	return eventRepository.findOne(eventid);
}
	
	

}

 
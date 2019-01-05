package com.example.demo.controller;



import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//import org.springframework.security.core.context.SecurityContextHolder;
import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.EventService;
import com.example.demo.services.UserService;


@Controller
@SessionAttributes("user")
public class EventController {

@Autowired
private EventService eventService;
private UserService userService;

@Autowired
private EventRepository er;

@Autowired
private UserRepository ur;

@ModelAttribute("user")
public User setUpUserForm() {
   return new User();
}
	

	@RequestMapping("/event")
public String Welcome(HttpServletRequest request)
{request.setAttribute("mode","MODE_HOME");
	return "homepage";
}
	
	@RequestMapping("/events456")
	public String Welcome1(HttpServletRequest request)
	{request.setAttribute("mode","MODE_HOME");
		return "trainer";
	}
		
	
	@RequestMapping(method = RequestMethod.POST,value="/eventregister")
	public String registeration(HttpServletRequest request)
	{
request.setAttribute("mode","EVENT_REGISTER");
	return "homepage";
	}	
	

	
	@PostMapping("/save-event")
	public String registerUser(@ModelAttribute Event event,BindingResult bindingResult,HttpServletRequest request) {
		
	//	Authentication auth
		// org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      //String name = auth.getName();
	      //get logged in username
	 //     System.out.println("USERRRRRRRr"+name);
		
		eventService.saveMyEvent(event);
	request.setAttribute("mode", "EVENT_REGISTER");
	
	//Principal principal=request.getUserPrincipal() ;
//	String name=null;
//	String name =principal.getName();
//	System.out.println("#######################"+principal.getName());
		return "homepage";
		
	}	
//	@GetMapping("/show-users")
//	public String showAllUser(HttpServletRequest request) {
//	request.setAttribute("users",userService.showAllUsers());
//		request.setAttribute("mode","ALL_USERS");
//		return "homepage";
//	}
//
//	@RequestMapping("/delete-user")
//	public String deleteUser(@RequestParam int id,HttpServletRequest request ) {
//		userService.deleteMyuser(id);
//		request.setAttribute("users",userService.showAllUsers());
//		request.setAttribute("mode","ALL_USERS");
//		return "homepage";
//	}
//
//	@RequestMapping("/edit-user")
//	public String editUser(@RequestParam int id,HttpServletRequest request)  {
//		request.setAttribute("user",userService.editUser(id));
//		request.setAttribute("mode","MODE_UPDATE");
//		return "homepage3";
//	}
//		
		
//		public String showAllEvents(HttpServletRequest request) {
//		request.setAttribute("events",eventService.showAllEvents());
//			request.setAttribute("mode","ALL_USERS");
//			return "homepage";
//		}
//	
@RequestMapping("/show-events")
	public String showAllEvents(HttpServletRequest request) {
		request.setAttribute("events",eventService.showAllEvents());
		request.setAttribute("mode","ALL_EVENTS");
		return "homepage2";
	}

@RequestMapping("/show-events1234")
public String showAllEvents1234(HttpServletRequest request,@ModelAttribute User user) {
	System.out.println("user is event"+user.getUsername());
	request.setAttribute("events",eventService.showAllEvents());
	request.setAttribute("mode","ALL_EVENTS");
	return "user2";
}




@RequestMapping("/enrolevent")
public String enrolledevents1(HttpServletRequest request,@ModelAttribute User user) {
    System.out.println("enrolled name"+user.getUsername());
    User u= ur.findByUsername(user.getUsername());
    int coin=u.getCoin();
	request.setAttribute("events",eventService.showAllcheck(u.getRegisteredevent()));
	
	request.setAttribute("mode","ALL_EVENTS");
	return "user4";
}


@RequestMapping("/delete-events")
public String deleteMyevent(@RequestParam int eventid,HttpServletRequest request ) {
	eventService.deleteMyevent(eventid);
	request.setAttribute("events",eventService.showAllEvents());
	request.setAttribute("mode","ALL_EVENTS");
	return "homepage2";
}

@RequestMapping("/enroll")
public String enroll(@RequestParam int id,HttpServletRequest request ,@ModelAttribute User user,@RequestParam int co) {
	System.out.println("coins are "+co);
	System.out.println("user in session"+user.getUsername());
	User u=ur.findByUsername(user.getUsername());
	System.out.println("user is "+u.getUsername());
	if(co<u.getCoin())
	{
		int d= u.getCoin();
		d=d-co;
		System.out.println("coins after purchasing event"+d);
	Event e2= er.findByEventid(id);
	System.out.println("id from event "+e2.getEnrolluser());
	Event e1=eventService.editEvent(id);	
	String q=e1.getEnrolluser();
	StringBuffer sb=new StringBuffer();
	if(q==(null))
		e1.setEnrolluser(user.getUsername());
	else
		e1.setEnrolluser(sb.append(q).append("/").append(user.getUsername()).toString());
	
	String g=u.getRegisteredevent();
	StringBuffer s=new StringBuffer();
	if(g==null)
	{
		System.out.println(e1.getEventname());
		ur.setUserInfoById(e1.getEventname(),u.getUsername());
		ur.setUserCoinById(d,u.getUsername());
	
	}
		else 
		{
			ur.setUserInfoById(s.append(g).append("/").append(e1.getEventname()).toString(),u.getUsername());
			ur.setUserCoinById(d,u.getUsername());
			user.setCoins(d);
		}
		eventService.saveMyEvent(e1);
	return "user1";
	}
	else 
	{
		return "user5";
	}
}
	
	}



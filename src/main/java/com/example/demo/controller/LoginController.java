package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Event;
import com.example.demo.model.Exercise;
import com.example.demo.model.User;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.services.UserService;

//import io.undertow.servlet.spec.HttpServletResponseImpl;


@SessionAttributes("user")
@Controller
public class LoginController {

	@Autowired
private UserService userService;
	
	@Autowired
	private ExerciseRepository exrepo;

	@RequestMapping("/welcome")
public String Welcome(HttpServletRequest request)
{request.setAttribute("mode","MODE_HOME");
	return "welcomepage2";
}

	@ModelAttribute("user")
	public User setUpUserForm() {
	   return new User();
	}
	
@RequestMapping("/register")
	public String registeration(HttpServletRequest request)
	{
request.setAttribute("mode","MODE_REGISTER");
	return "welcomepage";
	}

@RequestMapping("/user1")
public String user1(HttpServletRequest request,@ModelAttribute User user)
{
System.out.println("user is from user1"+user.getUsername());
request.setAttribute("mode","MODE_REGISTER");
return "user1";
}


@PostMapping("/save-user")
public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request) {
userService.saveMyUser(user);
request.setAttribute("mode", "MODE_HOME");
	return "welcomepage";
	
}

@GetMapping("/show-users")
public String showAllUser(HttpServletRequest request) {
request.setAttribute("users",userService.showAllUsers());
	request.setAttribute("mode","ALL_USERS");
	return "homepage3";
}


@GetMapping("/show-user123")
public String showAllUser123(HttpServletRequest request) {
request.setAttribute("users",userService.showAllUsers());
	request.setAttribute("mode","ALL_USERS");
	return "trainer3";
}

@GetMapping("/show-user1234")
public String showAllUser1234(HttpServletRequest request) {
request.setAttribute("users",userService.showAllUsers());
	request.setAttribute("mode","ALL_USERS2");
	return "trainer4";
}

@GetMapping("/show-user12345")
public String showAllUser12345(HttpServletRequest request) {
request.setAttribute("users",userService.showAllUsers());
	request.setAttribute("mode","ALL_USERS2");
	return "trainer5";
}

@RequestMapping("/delete-user")
public String deleteUser(@RequestParam int id,HttpServletRequest request ) {
	userService.deleteMyuser(id);
	request.setAttribute("users",userService.showAllUsers());
	request.setAttribute("mode","ALL_USERS");
	return "homepage3";
}

@RequestMapping("/edit-user")
public String editUser(@RequestParam int id,HttpServletRequest request)  {
	request.setAttribute("user",userService.editUser(id));
	request.setAttribute("mode","MODE_UPDATE");
	return "homepage3";
}

@RequestMapping("/login")
public String login(HttpServletRequest request) {
	request.setAttribute("mode","MODE_LOGIN");
	return "welcomepage";
}

@RequestMapping("/logout")
public String logout(HttpServletRequest request) throws ServletException
{ request.logout();
return "welcomepage2";

		}

@RequestMapping("/exer")
public String excer(@ModelAttribute User user)
{

	return "userexercise";
}


@RequestMapping("/delex")
public ModelAndView delex(@ModelAttribute User user,@RequestParam int id)
{
    exrepo.delete(id);
    List<Exercise> e1= new ArrayList<Exercise>();
    ModelAndView mv=new ModelAndView();
    for(Exercise ex :exrepo.findAll()) {
		e1.add(ex);
	}
   mv.addObject("exer", e1);
   mv.setViewName("myexercise");
	return mv;
	//return "myexercise";
}


@RequestMapping("/showex")
public ModelAndView showAllEx(HttpServletRequest request,@ModelAttribute User user) {
    List<Exercise> e1= new ArrayList<Exercise>();
    ModelAndView mv=new ModelAndView();
    for(Exercise ex :exrepo.findByUname(user.getUsername())) {
		e1.add(ex);
	}
   mv.addObject("exer", e1);
   mv.setViewName("myexercise");
	return mv;
}



@RequestMapping("/exadd")
public String exceradd(@ModelAttribute User user,@RequestParam String exname1)
{
	User u1=userService.findByusername(user.getUsername());
	System.out.println("username from exercise"+u1.getUsername());
	Exercise e1= new Exercise ();
	e1.setExname(exname1);
	e1.setUname(u1.getUsername());
	exrepo.save(e1);
	
	return "userexercise";
}




@RequestMapping ("/login-user")
public String loginUser(@ModelAttribute("user") User user, HttpServletRequest request) {
	//System.out.print("userrrrrrrrrrr"+user.getEmail());
	User user2=userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	//User user2=userService.findbyUsername(user.getUsername());
	System.out.println(user2.getRole());
	String temp=user2.getRole();
	
	user.setUsername(user2.getUsername());
	user.setCoins(user2.getCoin());
	user.setPassword(user2.getPassword());
	if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
		if(temp.equalsIgnoreCase("ADMIN"))
		{
			return "homepage";

		}
		else if (temp.equalsIgnoreCase("user"))
		{//System.out.println("$$$$$$$$$$$$$$$$");
//		System.out.print("########"+user.getUsername());
			return "user1";
		}
		else
		{
			return "trainer";
		}
	}
	else {
		request.setAttribute("error", "Invalid Username or Password");
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
		
	}
	
	
}}

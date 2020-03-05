package com.tuningboard.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tuningboard.domain.UserInfo;
import com.tuningboard.service.UserInfoService;

@Controller
public class UserInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	 @Autowired
	 private UserInfoService userinfoservice;
	 
	 @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	 public String login(Model model) {
	  return "user/login";
	 }
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	 public String signup(Model model) {
	  UserInfo user = new UserInfo();
	  model.addAttribute("user", user);
	  
	  return "user/signup";
	 }
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	 public String createUser(@Valid UserInfo userinfo, BindingResult bindingResult, Model model) {
	  logger.debug("getEmail {}", userinfo.getEmail());
	  UserInfo userExists = userinfoservice.findByEmail(userinfo.getEmail());
	  
	  if(userExists != null) {
	   bindingResult.rejectValue("email", "error.user", "This email already exists!");
	  }
	  if(bindingResult.hasErrors()) {
		  return "user/signup";
	  } else {
	   userinfoservice.save(userinfo);
	   model.addAttribute("msg", "User has been registered successfully!");
	   model.addAttribute("user", new UserInfo());
	  }
	  
	  return "user/signup";
	 }
	 
/*	 @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
	 public String home(Model model) {
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  UserInfo userinfo = userinfoservice.findByEmail(auth.getName());
	  model.addAttribute("username", userinfo.getFirstname() + " " + userinfo.getLastname());
	  return "home/home";
	 }*/
	 
	 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	 public String accessDenied(Model model) {
	  return "errors/error";
	 }
}
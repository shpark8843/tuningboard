package com.tuningboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuningboard.service.SvcInfoService;

@Controller
@RequestMapping("/svcinfo")
public class SvcInfoController {

	@Autowired
	private SvcInfoService svcinfoservice;
		
	@RequestMapping(value= {"", "/"}, method=RequestMethod.GET)
	public String getsvcinfo(@RequestParam (value = "id", defaultValue = "0") Long id,  Model model) throws Exception{
        model.addAttribute("svcinfo", svcinfoservice.findById(id));
        	return "/svcinfo/registerForm";	
	}
	
	@RequestMapping(value= {"/list"}, method=RequestMethod.GET)
	public String Page(@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 10) Pageable pageable , Model model) throws Exception{
/*		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userinfo = userinfoservice.findByEmail(auth.getName());
		model.addAttribute("username", userinfo.getFirstname() + " " + userinfo.getLastname());
*/		model.addAttribute("svcinfoList", svcinfoservice.findAll(pageable));
        return "/svcinfo/svcinfoList";
	}
	
	
	
	  @RequestMapping(value= {"/search"}, method=RequestMethod.GET) 
	  public String search(@RequestParam(value = "sch_type") String sch_type, @RequestParam(value = "sch_value") String sch_value, Model model) throws Exception{
		  model.addAttribute("sch_type", sch_type); 
		  switch (sch_type) { 
		  case "svcId":
			  model.addAttribute("svcinfoList", svcinfoservice.findAllBySvcId(sch_value));
			  break; 
		  case "svcName": 
			  model.addAttribute("svcinfoList",
			  svcinfoservice.findAllBySvcName(sch_value)); 
			  break; 
		  case "type":
			  model.addAttribute("svcinfoList", svcinfoservice.findAllByType(sch_value));
			  break; 
		  case "perfTest": 
			  model.addAttribute("svcinfoList",
			  svcinfoservice.findAllByPerfTest(sch_value)); 
			  break; 
		} 
		  return "/svcinfo/svcinfoList"; 
	}
}

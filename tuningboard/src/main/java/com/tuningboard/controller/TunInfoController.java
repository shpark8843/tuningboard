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

import com.tuningboard.service.TunInfoService;

@Controller
@RequestMapping("/tuninfo")
public class TunInfoController {

	@Autowired
	private TunInfoService tuninfoservice;
		
	@RequestMapping(value= {"", "/"}, method=RequestMethod.GET)
	public String gettuninfo(@RequestParam (value = "id", defaultValue = "0") Long id,  Model model) throws Exception{
        model.addAttribute("tuninfo", tuninfoservice.findById(id));
        	return "/tuninfo/registerForm";
	}
	
	@RequestMapping(value= {"/list"}, method=RequestMethod.GET)
	public String Page(@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 10) Pageable pageable , Model model) throws Exception{
        model.addAttribute("tuninfoList", tuninfoservice.findAll(pageable));
        return "/tuninfo/tuninfoList";
	}
	
	@RequestMapping(value= {"/search"}, method=RequestMethod.GET)
	public String search(@RequestParam(value = "sch_type") String sch_type, @RequestParam(value = "sch_value") String sch_value, Model model) throws Exception{
        
		model.addAttribute("sch_type", sch_type);
		switch (sch_type) {
		case "svcId": 
			model.addAttribute("tuninfoList", tuninfoservice.findAllBySvcId(sch_value));
			break;
		case "defType": 
			model.addAttribute("tuninfoList", tuninfoservice.findAllByDefType(sch_value));
			break;
		case "tuner": 
			model.addAttribute("tuninfoList", tuninfoservice.findAllByTuner(sch_value));
			break;
		case "responsible": 
			model.addAttribute("tuninfoList", tuninfoservice.findAllByResponsible(sch_value));
			break;
		}
		return "/tuninfo/tuninfoList";
	}		

}

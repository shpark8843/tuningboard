package com.tuningboard.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuningboard.domain.DefTypeStatisticsDTO;
import com.tuningboard.domain.ServiceStatisticsDTO;
import com.tuningboard.domain.TuningStatisticsDTO;
import com.tuningboard.service.DefTypeStatisticsService;
import com.tuningboard.service.ServiceStatisticsService;
import com.tuningboard.service.TuningStatisticsService;

@Controller
@RequestMapping(value= {"/report"})
public class ReportController {

	//private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
		
	 @Autowired
	 private ServiceStatisticsService servicestatisticsservice;

	 @Autowired
	 private TuningStatisticsService tuningstatisticsservice;

	 @Autowired
	 private DefTypeStatisticsService deftypestatisticsservice;

	@RequestMapping(value= "/svcstat", method=RequestMethod.GET)
	public String getSvcStatus(Model model) throws Exception{
		LocalDate enddate = LocalDate.now();
        LocalDate startdate = enddate.minusDays(5);  
        List<ServiceStatisticsDTO> list = servicestatisticsservice.getServiceStatistics(startdate, enddate);
        model.addAttribute("svcstatList", list);
        
        for(ServiceStatisticsDTO dto : list)
        {
        	model.addAttribute(dto.getType(), list.subList(0, 1));
        }
        return "/report/svcstat";
	}
	
	@RequestMapping(value= "/Search", method=RequestMethod.GET)
	public String getSvcStatus(@RequestParam (value = "startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startdate, @RequestParam (value = "enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate enddate,  Model model) throws Exception{
		List<ServiceStatisticsDTO> list = servicestatisticsservice.getServiceStatistics(startdate, enddate);
        model.addAttribute("svcstatList", list);   
        for(ServiceStatisticsDTO dto : list)
        {
        	model.addAttribute(dto.getType(), list.subList(0, 1));
        }
		return "/report/svcstat";
	}
	
	@RequestMapping(value= "/tunstat", method=RequestMethod.GET)
	public String getTunStatus(Model model) throws Exception{                       
		List<TuningStatisticsDTO> list = tuningstatisticsservice.getTuningStatistics();
		List<DefTypeStatisticsDTO> list1 = deftypestatisticsservice.getDefTypeStatistics();
		model.addAttribute("tunstatList", list);
		model.addAttribute("deftypeList", list1);
    	return "/report/tunstat";
	}
}

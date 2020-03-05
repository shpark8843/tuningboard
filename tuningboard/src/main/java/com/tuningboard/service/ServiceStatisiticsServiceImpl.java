package com.tuningboard.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuningboard.controller.UserInfoController;
import com.tuningboard.domain.ServiceStatisticsDTO;
import com.tuningboard.mapper.ServiceStatisticsMapper;

@Service
public class ServiceStatisiticsServiceImpl implements ServiceStatisticsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@Autowired
	ServiceStatisticsMapper servicestatisticsmappper;
	
	@Override
	public List<ServiceStatisticsDTO> getServiceStatistics(LocalDate startdate, LocalDate enddate) {
		
		logger.debug("startdate {} enddate {}", startdate, enddate);
		
		return servicestatisticsmappper.getServiceStatistics(startdate, enddate);
	}
}

package com.tuningboard.service;

import java.time.LocalDate;
import java.util.List;

import com.tuningboard.domain.ServiceStatisticsDTO;

public interface ServiceStatisticsService {

	public List<ServiceStatisticsDTO> getServiceStatistics(LocalDate startdate, LocalDate enddate) ; 
}

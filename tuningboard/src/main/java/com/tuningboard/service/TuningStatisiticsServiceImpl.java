package com.tuningboard.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuningboard.controller.UserInfoController;
import com.tuningboard.domain.TuningStatisticsDTO;
import com.tuningboard.mapper.TuningStatisticsMapper;

@Service
public class TuningStatisiticsServiceImpl implements TuningStatisticsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@Autowired
	TuningStatisticsMapper servicestatisticsmappper;
	
	@Override
	public List<TuningStatisticsDTO> getTuningStatistics() {
		
		return servicestatisticsmappper.getTuningStatistics();
	}
}

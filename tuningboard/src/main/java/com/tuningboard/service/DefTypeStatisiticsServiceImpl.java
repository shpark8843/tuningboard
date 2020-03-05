package com.tuningboard.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuningboard.domain.DefTypeStatisticsDTO;
import com.tuningboard.mapper.DefTypeStatisticsMapper;

@Service
public class DefTypeStatisiticsServiceImpl implements DefTypeStatisticsService {
	
	private static final Logger logger = LoggerFactory.getLogger(DefTypeStatisiticsServiceImpl.class);

	@Autowired
	DefTypeStatisticsMapper deftypestatisticsmappper;
	
	@Override
	public List<DefTypeStatisticsDTO> getDefTypeStatistics() {
		
//		logger.debug("startdate {} enddate {}", startdate, enddate);
		
		return deftypestatisticsmappper.getDefTypeStatistics();
	}
}

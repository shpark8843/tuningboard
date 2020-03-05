package com.tuningboard.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tuningboard.domain.ServiceStatisticsDTO;

@Mapper
public interface ServiceStatisticsMapper {

	public List<ServiceStatisticsDTO> getServiceStatistics(@Param("startdate") LocalDate startdate, @Param("enddate") LocalDate enddate);
}

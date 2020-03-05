package com.tuningboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tuningboard.domain.DefTypeStatisticsDTO;

@Mapper
public interface DefTypeStatisticsMapper {

	public List<DefTypeStatisticsDTO> getDefTypeStatistics();
}

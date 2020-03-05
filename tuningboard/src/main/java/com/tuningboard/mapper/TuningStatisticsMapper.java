package com.tuningboard.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.tuningboard.domain.TuningStatisticsDTO;

@Mapper
public interface TuningStatisticsMapper {

	public List<TuningStatisticsDTO> getTuningStatistics();
}

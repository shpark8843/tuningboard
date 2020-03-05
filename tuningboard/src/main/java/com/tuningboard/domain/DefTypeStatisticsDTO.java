package com.tuningboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DefTypeStatisticsDTO{

	private String deftype;	
	private Long cnt;
	
	public DefTypeStatisticsDTO(String deftype, Long cnt) { 
		this.deftype = deftype;
		this.cnt = cnt;	 
	}
}

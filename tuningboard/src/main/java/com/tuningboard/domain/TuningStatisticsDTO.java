package com.tuningboard.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TuningStatisticsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7865725480616311306L;
	private String type;	
	private Long svc_Count;
	private Long total;
	private Long open;
	private Long under_Guide;
	private Long in_progress;
	private Long fixed;
	private Long reopen;
	private Long closed;
	private Long closed1;
	private Long total_closed;
	private Long ratio;
	private Long total_defect;
	private Long app;
	private Long sql;
	private Long appsql;
	private Long tmf;
	private Long i_f;
	
	public TuningStatisticsDTO(String type, Long svc_Count, Long total, Long open, Long under_Guide, Long in_progress, Long fixed, Long reopen, Long closed, Long closed1,
			Long total_closed, Long ratio, Long total_defect, Long app , Long sql, Long appsql, Long tmf, Long i_f) { 
		this.type = type;
		this.svc_Count = svc_Count;
		this.total = total; 
		this.open = open; 
		this.under_Guide = under_Guide;
		this.in_progress = in_progress; 
		this.fixed = fixed; 
		this.reopen = reopen;
		this.closed = closed; 
		this.closed1 = closed1; 
		this.total_closed = total_closed;
		this.ratio = ratio; 
		this.total_defect = total_defect; 
		this.app = app;
		this.sql = sql;
		this.appsql = appsql;
		this.tmf = tmf;
		this.i_f = i_f;		
	}
}

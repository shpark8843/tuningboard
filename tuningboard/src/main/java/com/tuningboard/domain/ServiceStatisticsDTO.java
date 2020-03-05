package com.tuningboard.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceStatisticsDTO{

	private String type;	
	private Long svc_Count;
	private Long mcp_8;
	private Long mcp_3_8;
	private Long mcp_3;
	private Long mcp_Ratio;
	private Long cp_8;
	private Long cp_3_8;
	private Long cp_3;
	private Long cp_Ratio;
	private Long etc_8;
	private Long etc_3_8;
	private Long etc_3;
	private Long etc_Ratio;
	
	public ServiceStatisticsDTO(String type, Long svc_Count, Long mcp_8, Long mcp_3_8, Long mcp_3, Long mcp_Ratio, Long cp_8, Long cp_3_8, Long cp_3, Long cp_Ratio,
			Long etc_8, Long etc_3_8, Long etc_3, Long etc_Ratio) { 
		this.type = type;
		this.svc_Count = svc_Count;
		this.mcp_8 = mcp_8; 
		this.mcp_3_8 = mcp_3_8; 
		this.mcp_3 = mcp_3;
		this.mcp_Ratio = mcp_Ratio; 
		this.cp_8 = cp_8; 
		this.cp_3_8 = cp_3_8;
		this.cp_3 = cp_3; 
		this.cp_Ratio = cp_Ratio; 
		this.etc_8 = etc_8;
		this.etc_3_8 = etc_3_8; 
		this.etc_3 = etc_3; 
		this.etc_Ratio = etc_Ratio;	 
	}
}

package com.tuningboard.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SvcInfoDTO {
	
	private Long id;
	private String svcId;	
	private String svcName;	
	private Type type;	
	private String bizType;	
	private String bizDetail;	
	private String scnId;	
	private String scnName;	
	private Priority priority;	
	private String leader;	
	private String developer;	
	private String designer;	
	private String customer;	
	private YesNo perfTest;	
	private String funName;	
	private String subFunName;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private List<TunInfo> tunInfos; 
	
	public SvcInfoDTO(long id, String svcId, String svcName, Type type, String bizType, String bizDetail, String scnId, 
		       String scnName, Priority priority, String leader, String developer, String designer, String customer, 
		       YesNo perfTest, String funName, String subFunName, LocalDateTime createdDate, LocalDateTime updatedDate) { 
		this.id = id;
		this.svcId = svcId;
		this.svcName = svcName; 
		this.type = type; 
		this.bizType = bizType;
		this.bizDetail = bizDetail; 
		this.scnId = scnId; 
		this.scnName = scnName;
		this.priority = priority; 
		this.leader = leader; 
		this.developer = developer;
		this.designer = designer; 
		this.customer = customer; 
		this.perfTest = perfTest;
		this.funName = funName; 
		this.subFunName = subFunName;	  
		this.createdDate = createdDate;	
		this.updatedDate = updatedDate;	  
	}
}
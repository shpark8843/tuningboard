package com.tuningboard.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class SvcInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String svcId;	

	@Column
	private String svcName;	
	
	@Column
	@Enumerated(EnumType.STRING)
	private Type type;	
	
	@Column
	private String bizType;	
	
	@Column
	private String bizDetail;	
	
	@Column
	private String scnId;	
	
	@Column
	private String scnName;	
	
	@Column
	@Enumerated(EnumType.STRING)
	private Priority priority;	
	
	@Column
	private String leader;
	
	@Column
	private String developer;	
	
	@Column
	private String designer;	
	
	@Column
	private String customer;	
	
	@Column
	@Enumerated(EnumType.STRING)
	private YesNo perfTest;	
	
	@Column
	private String funName;	
	
	@Column
	private String subFunName;	
	
	@Column
	@CreationTimestamp
	private LocalDateTime createdDate;	
	
	@Column
	@UpdateTimestamp
	private LocalDateTime updatedDate;	
	
	@OneToMany(mappedBy = "svcinfo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<TunInfo> tunInfos = new ArrayList<TunInfo>();
	
	@Builder
	public SvcInfo(String svcId, String svcName, Type type, String bizType, String bizDetail, String scnId, 
			       String scnName, Priority priority, String leader, String developer, String designer, String customer, 
			       YesNo perfTest, String funName, String subFunName) { 
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
	  }
	
	// 연관관계 메소드//
    public void addTunInfo(TunInfo tuninfo) {
    	tunInfos.add(tuninfo);
    	tuninfo.setSvcinfo(this);
    }

	public static SvcInfo createSvcInfo(SvcInfoDTO dto, TunInfo tuninfo) {
		// TODO Auto-generated method stub
		SvcInfo svcinfo = SvcInfo.builder() 
				.svcId(dto.getSvcId())
				.svcName(dto.getSvcName())
				.type(dto.getType())
				.bizType(dto.getBizType())
				.bizDetail(dto.getBizDetail())
				.scnId(dto.getScnId())
				.scnName(dto.getScnName())
				.priority(dto.getPriority())
				.leader(dto.getLeader())
				.developer(dto.getDeveloper())
				.designer(dto.getDesigner())
				.customer(dto.getCustomer())
				.perfTest(dto.getPerfTest())
				.funName(dto.getFunName())
				.subFunName(dto.getSubFunName())
//				.createdDate(dto.getCreatedDate())
//				.updatedDate(dto.getUpdatedDate())				
				.build();
		svcinfo.addTunInfo(tuninfo);
		return svcinfo;
	}

	public void updateSvcInfo(SvcInfoDTO dto) {
		this.svcId = dto.getSvcId();
		this.svcName = dto.getSvcName();
		this.type = dto.getType();
		this.bizType = dto.getBizType();
		this.bizDetail = dto.getBizDetail();
		this.scnId = dto.getScnId();
		this.scnName = dto.getScnName();
		this.priority = dto.getPriority();
		this.leader = dto.getLeader();
		this.developer = dto.getDeveloper();
		this.designer = dto.getDesigner();
		this.customer = dto.getCustomer();
		this.perfTest = dto.getPerfTest();
		this.funName = dto.getFunName();
		this.subFunName = dto.getSubFunName();
//		this.createdDate = dto.getCreatedDate();
//		this.updatedDate = dto.getUpdatedDate();		
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public void setTunInfos(List<TunInfo> tunInfos) {
		this.tunInfos = tunInfos;
	}
}
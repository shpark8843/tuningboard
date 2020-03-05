package com.tuningboard.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TunInfo implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private long id;	
	
	@Column
	@Enumerated(EnumType.STRING)
	private YesNo tunType;
	
	@Column
	@Enumerated(EnumType.STRING)
	private DefType defType;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TestType testType;
	
	@Column
	private String reviewer;
	
	@Column
	private LocalDateTime reviewedDate;
	
	@Column
	private String description;
	
	@Column
	@Enumerated(EnumType.STRING)
	private YesNo submitType;
	
	@Column
	private LocalDateTime submittedDate;
	
	@Column
	@Enumerated(EnumType.STRING)
	private YesNo updateType;

	@Column
	private LocalDateTime updatedDate;
	
	@Column
	private String tuner;
	
	@Column
	private String responsible;

	@Column
	@Enumerated(EnumType.STRING)
	private YesNo closeType;	

	@Column
	private LocalDateTime closedDate;

	
	@Column
	@Enumerated(EnumType.STRING)
	private Status status;	
	
	@Column
	@Enumerated(EnumType.STRING)
	private DetailType detailType;
	
	@Column
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "svcinfo_id", nullable = false, updatable = false)
	private SvcInfo svcinfo;	

	@Builder
	public TunInfo(YesNo tunType, DefType defType, TestType testType, String reviewer, LocalDateTime reviewedDate, String description, YesNo submitType,
			LocalDateTime submittedDate, YesNo updateType, LocalDateTime updatedDate, String tuner, String responsible, YesNo closeType, LocalDateTime closedDate, Status status, DetailType detailType, String comment, SvcInfo svcinfo) {
		this.tunType = tunType;
		this.defType = defType;
		this.testType = testType;
		this.reviewer = reviewer;
		this.reviewedDate = reviewedDate;
		this.description = description;
		this.submitType = submitType;
		this.submittedDate = submittedDate;
		this.updateType = updateType;
		this.updatedDate = updatedDate;
		this.tuner = tuner;
		this.responsible = responsible;
		this.closeType = closeType;
		this.closedDate = closedDate;
		this.status = status;
		this.detailType = detailType;
		this.comment = comment;
		this.svcinfo = svcinfo;
	}
	
	public static TunInfo createTunInfo() {
		TunInfo tuninfo = new TunInfo();
		tuninfo.setTunType(YesNo.N);
		tuninfo.setSubmitType(YesNo.N);
		tuninfo.setUpdateType(YesNo.N);
		tuninfo.setCloseType(YesNo.N);
		tuninfo.setStatus(Status.OPEN);
		return tuninfo;
	}
	
	public static TunInfo createTunInfo(TunInfoDTO dto) {
		TunInfo tuninfo = new TunInfo();
		tuninfo.setTunType(YesNo.N);
		tuninfo.setSubmitType(YesNo.N);
		tuninfo.setUpdateType(YesNo.N);
		tuninfo.setCloseType(YesNo.N);
		tuninfo.setStatus(Status.NEW);
		return tuninfo;
	}

	public void updateTunInfo(TunInfoDTO dto) {
		this.tunType = dto.getTunType();
		this.defType = dto.getDefType();
		this.testType = dto.getTestType();
		this.reviewer = dto.getReviewer();
		this.reviewedDate = dto.getReviewedDate();
		this.description = dto.getDescription();
		this.submitType = dto.getSubmitType();
		this.submittedDate = dto.getSubmittedDate();
		this.updateType = dto.getUpdateType();
		this.updatedDate = dto.getUpdatedDate();
		this.tuner = dto.getTuner();
		this.responsible = dto.getResponsible();
		this.status = dto.getStatus();
		this.detailType = dto.getDetailType();
		this.closeType = dto.getCloseType();
		this.closedDate = dto.getClosedDate();		
		this.comment = dto.getComment();
	}

	public void setTunType(YesNo tunType) {
		// TODO Auto-generated method stub
		this.tunType = tunType;
	}

	public void setTestType(TestType testType) {
		// TODO Auto-generated method stub
		this.testType = testType;
	}

	public void setDefType(DefType defType) {
		// TODO Auto-generated method stub
		this.defType = defType;
	}

	public void setSubmitType(YesNo submitType) {
		// TODO Auto-generated method stub
		this.submitType = submitType;
	}


	public void setUpdateType(YesNo updateType) {
		// TODO Auto-generated method stub
		this.updateType = updateType;
	}
	
	public void setCloseType(YesNo closeType) {
		// TODO Auto-generated method stub
		this.closeType = closeType;
	}

	public void setStatus(Status status) {
		// TODO Auto-generated method stub
		this.status = status;
	}

	public void setdeFectType(YesNo tunType) {
		// TODO Auto-generated method stub
		this.tunType = tunType;
	}

	public void setSvcinfo(SvcInfo svcinfo) {
		// TODO Auto-generated method stub
		//this.svcinfo = svcinfo;
		if(this.svcinfo != null)
	        this.svcinfo.getTunInfos().remove(this);
	    this.svcinfo = svcinfo;
	    svcinfo.getTunInfos().add(this);
	}
}

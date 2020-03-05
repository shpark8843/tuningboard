package com.tuningboard.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TunInfoDTO {

	private String svcId;	
	private String svcName;	
	private Long id;
	private YesNo tunType;
	private DefType defType;
	private TestType testType;
	private String reviewer;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime reviewedDate;
	private String description;
	private String tuner;
	private YesNo submitType;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime submittedDate;
	private String responsible;
	private YesNo updateType;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime updatedDate;
	private YesNo closeType;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime closedDate;
	private Status status;
	private DetailType detailType;
	private String comment;
	
	public TunInfoDTO(String svcId, String svcName, Long id, YesNo tunType, DefType defType, TestType testType, String reviewer, LocalDateTime reviewedDate, String description, String tuner, YesNo submitType,
		   LocalDateTime submittedDate, String responsible, YesNo updateType, LocalDateTime updatedDate, YesNo closeType, LocalDateTime closedDate, Status status, DetailType detailType, String comment) {
		this.svcId = svcId;
		this.svcName = svcName;
		this.id = id;
		this.tunType = tunType;
		this.defType = defType;
		this.testType = testType;
		this.reviewer = reviewer;
		this.reviewedDate = reviewedDate;
		this.description = description;
		this.tuner = tuner;
		this.submitType = submitType;
		this.submittedDate = submittedDate;
		this.responsible = responsible;
		this.updateType = updateType;
		this.updatedDate = updatedDate;
		this.closeType = closeType;
		this.closedDate = closedDate;
		this.status = status;
		this.detailType = detailType;
		this.comment = comment;		
	}
}

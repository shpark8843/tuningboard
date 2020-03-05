package com.tuningboard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuningboard.domain.TunInfo;
import com.tuningboard.domain.TunInfoDTO;

@Repository
@Transactional
public interface TunInfoRepository extends JpaRepository<TunInfo, Long> {

	@Query("SELECT new com.tuningboard.domain.TunInfoDTO(svc.svcId, svc.svcName, tun.id, tun.tunType, tun.defType, tun.testType, tun.reviewer, tun.reviewedDate, tun.description," + 
			   "tun.tuner, tun.submitType, tun.submittedDate, tun.responsible, tun.updateType, tun.updatedDate, tun.closeType, tun.closedDate, tun.status, tun.detailType, tun.comment) FROM SvcInfo svc JOIN svc.tunInfos tun")
		Page<TunInfoDTO> findAllDTO(Pageable pageable);

		@Query("SELECT new com.tuningboard.domain.TunInfoDTO(svc.svcId, svc.svcName, tun.id, tun.tunType, tun.defType, tun.testType, tun.reviewer, tun.reviewedDate, tun.description," + 
				   "tun.tuner, tun.submitType, tun.submittedDate, tun.responsible, tun.updateType, tun.updatedDate, tun.closeType, tun.closedDate, tun.status, tun.detailType, tun.comment) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE svc.id = :id")
		TunInfoDTO findByIdDTO(long id);
			
		@Query("SELECT new com.tuningboard.domain.TunInfoDTO(svc.svcId, svc.svcName, tun.id, tun.tunType, tun.defType, tun.testType, tun.reviewer, tun.reviewedDate, tun.description," + 
				   "tun.tuner, tun.submitType, tun.submittedDate, tun.responsible, tun.updateType, tun.updatedDate, tun.closeType, tun.closedDate, tun.status, tun.detailType, tun.comment) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE svc.svcId LIKE %:svcId%")
		List<TunInfoDTO> findAllBySvcIdDTO(String svcId);

		@Query("SELECT new com.tuningboard.domain.TunInfoDTO(svc.svcId, svc.svcName, tun.id, tun.tunType, tun.defType, tun.testType, tun.reviewer, tun.reviewedDate, tun.description," + 
				   "tun.tuner, tun.submitType, tun.submittedDate, tun.responsible, tun.updateType, tun.updatedDate, tun.closeType, tun.closedDate, tun.status, tun.detailType, tun.comment) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE tun.defType = :defType")
		List<TunInfoDTO> findAllByDefTypeDTO(String defType);

		@Query("SELECT new com.tuningboard.domain.TunInfoDTO(svc.svcId, svc.svcName, tun.id, tun.tunType, tun.defType, tun.testType, tun.reviewer, tun.reviewedDate, tun.description," + 
				   "tun.tuner, tun.submitType, tun.submittedDate, tun.responsible, tun.updateType, tun.updatedDate, tun.closeType, tun.closedDate, tun.status, tun.detailType, tun.comment) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE tun.tuner LIKE %:tuner%")
		List<TunInfoDTO> findAllByTunerDTO(String tuner);

		@Query("SELECT new com.tuningboard.domain.TunInfoDTO(svc.svcId, svc.svcName, tun.id, tun.tunType, tun.defType, tun.testType, tun.reviewer, tun.reviewedDate, tun.description," + 
				   "tun.tuner, tun.submitType, tun.submittedDate, tun.responsible, tun.updateType, tun.updatedDate, tun.closeType, tun.closedDate, tun.status, tun.detailType, tun.comment) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE tun.responsible LIKE %:responsible%")
		List<TunInfoDTO> findAllByResponsibleDTO(String responsible);

		@Query("SELECT new com.tuningboard.domain.TunInfoDTO(svc.svcId, svc.svcName, tun.id, tun.tunType, tun.defType, tun.testType, tun.reviewer, tun.reviewedDate, tun.description," + 
				   "tun.tuner, tun.submitType, tun.submittedDate, tun.responsible, tun.updateType, tun.updatedDate, tun.closeType, tun.closedDate, tun.status, tun.detailType, tun.comment) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE tun.status = :status")
		List<TunInfoDTO> findAllByStsDTO(String status);

}

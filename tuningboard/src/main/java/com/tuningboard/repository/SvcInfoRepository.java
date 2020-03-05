package com.tuningboard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuningboard.domain.SvcInfo;
import com.tuningboard.domain.SvcInfoDTO;

@Repository
@Transactional
public interface SvcInfoRepository extends JpaRepository<SvcInfo, Long> {

	@Query("SELECT new com.tuningboard.domain.SvcInfoDTO(svc.id, svc.svcId, svc.svcName, svc.type, svc.bizType, svc.bizDetail, svc.scnId, svc.scnName,"
			+ "svc.priority, svc.leader, svc.developer, svc.designer, svc.customer, svc.perfTest, svc.funName,"
			+ "svc.subFunName, svc.createdDate, svc.updatedDate) FROM SvcInfo svc JOIN svc.tunInfos tun")
	Page<SvcInfoDTO> findAllDTO(Pageable pageable);

	@Query("SELECT new com.tuningboard.domain.SvcInfoDTO(svc.id, svc.svcId, svc.svcName, svc.type, svc.bizType, svc.bizDetail, svc.scnId, svc.scnName,"
			+ "svc.priority, svc.leader, svc.developer, svc.designer, svc.customer, svc.perfTest, svc.funName,"
			+ "svc.subFunName, svc.createdDate, svc.updatedDate) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE svc.id = :id")
	SvcInfoDTO findByIdDTO(long id);

	@Query("SELECT new com.tuningboard.domain.SvcInfoDTO(svc.id, svc.svcId, svc.svcName, svc.type, svc.bizType, svc.bizDetail, svc.scnId, svc.scnName,"
			+ "svc.priority, svc.leader, svc.developer, svc.designer, svc.customer, svc.perfTest, svc.funName,"
			+ "svc.subFunName, svc.createdDate, svc.updatedDate) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE svc.svcId = :svcId")
	List<SvcInfoDTO> findAllBySvcIdDTO(String svcId);

	@Query("SELECT new com.tuningboard.domain.SvcInfoDTO(svc.id, svc.svcId, svc.svcName, svc.type, svc.bizType, svc.bizDetail, svc.scnId, svc.scnName,"
			+ "svc.priority, svc.leader, svc.developer, svc.designer, svc.customer, svc.perfTest, svc.funName,"
			+ "svc.subFunName, svc.createdDate, svc.updatedDate) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE svc.svcName = :svcName")
	List<SvcInfoDTO> findAllBySvcNameLikeDTO(String svcName);

	@Query("SELECT new com.tuningboard.domain.SvcInfoDTO(svc.id, svc.svcId, svc.svcName, svc.type, svc.bizType, svc.bizDetail, svc.scnId, svc.scnName,"
			+ "svc.priority, svc.leader, svc.developer, svc.designer, svc.customer, svc.perfTest, svc.funName,"
			+ "svc.subFunName,svc.createdDate, svc.updatedDate) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE svc.type = :type")
	List<SvcInfoDTO> findAllByTypeDTO(String type);

	@Query("SELECT new com.tuningboard.domain.SvcInfoDTO(svc.id, svc.svcId, svc.svcName, svc.type, svc.bizType, svc.bizDetail, svc.scnId, svc.scnName,"
			+ "svc.priority, svc.leader, svc.developer, svc.designer, svc.customer, svc.perfTest, svc.funName,"
			+ "svc.subFunName, svc.createdDate, svc.updatedDate) FROM SvcInfo svc JOIN svc.tunInfos tun WHERE svc.perfTest = :perfTest")
	List<SvcInfoDTO> findAllByPerfTestDTO(String perfTest);

}

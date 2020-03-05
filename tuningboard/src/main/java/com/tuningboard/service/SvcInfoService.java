package com.tuningboard.service;

import com.tuningboard.domain.SvcInfo;
import com.tuningboard.domain.SvcInfoDTO;
import com.tuningboard.domain.TunInfo;
import com.tuningboard.repository.SvcInfoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SvcInfoService {

	@Autowired
	private SvcInfoRepository svcinfoRepository;

    @Transactional(readOnly = true)
	public SvcInfo findById(long id) {
        return svcinfoRepository.findById(id).orElse(new SvcInfo());
    }

	public Page<SvcInfoDTO> findAll(Pageable pageable){
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, pageable.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
		return svcinfoRepository.findAllDTO(pageable);
	}

	public List<SvcInfoDTO> findAllBySvcId(String svcId) {
		return svcinfoRepository.findAllBySvcIdDTO(svcId);
	}
	
	public List<SvcInfoDTO> findAllBySvcName(String svcName) {
		return svcinfoRepository.findAllBySvcNameLikeDTO(svcName);
	}

	public List<SvcInfoDTO> findAllByType(String type) {
		return svcinfoRepository.findAllByTypeDTO(type);
	}

	public List<SvcInfoDTO> findAllByPerfTest(String perfTest) {
		return svcinfoRepository.findAllByPerfTestDTO(perfTest);
	}

	@Transactional
	public Long createSvcInfo(SvcInfoDTO dto) {
		//tunInfo 생성
		TunInfo tuninfo = TunInfo.createTunInfo();
		
		SvcInfo svcinfo = SvcInfo.createSvcInfo(dto, tuninfo);
        //주문 저장
		svcinfoRepository.save(svcinfo);
		
		return svcinfo.getId(); 				
	}

	@Transactional
	public SvcInfo update(long id, SvcInfoDTO dto) {
		final SvcInfo svcinfo = findById(id);
		svcinfo.updateSvcInfo(dto);
		return svcinfo;		
	}
	
	@Transactional
	public SvcInfo removeTunInfos(long id) {
	    final SvcInfo svcinfo = findById(id);
	    svcinfo.getTunInfos().clear(); // 전체 삭제
	    return svcinfo; // 실제 TunInfo 삭제 여부를 확인하기 위해 리턴
	}


	@Transactional
	public void remove(long id){
	    svcinfoRepository.deleteById(id); // 특정 항목 삭제
	}	
}

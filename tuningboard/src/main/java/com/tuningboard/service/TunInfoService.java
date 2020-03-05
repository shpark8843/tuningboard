package com.tuningboard.service;

import com.tuningboard.domain.TunInfo;
import com.tuningboard.domain.TunInfoDTO;
import com.tuningboard.repository.TunInfoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TunInfoService {

	@Autowired
	private TunInfoRepository tuninfoRepository;

    @Transactional(readOnly = true)
	public TunInfo findById(long id) {
        return tuninfoRepository.findById(id).orElse(new TunInfo());
    }

	public Page<TunInfoDTO> findAll(Pageable pageable){
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, pageable.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
		return tuninfoRepository.findAllDTO(pageable);
	}

	public List<TunInfoDTO> findAllBySvcId(String svcId) {
		return tuninfoRepository.findAllBySvcIdDTO(svcId);
	}

	public List<TunInfoDTO> findAllByDefType(String defType) {
		return tuninfoRepository.findAllByDefTypeDTO(defType);
	}

	public List<TunInfoDTO> findAllByTuner(String tuner) {
		return tuninfoRepository.findAllByTunerDTO(tuner);
	}

	public List<TunInfoDTO> findAllByResponsible(String responsbile) {
		return tuninfoRepository.findAllByResponsibleDTO(responsbile);
	}

	public List<TunInfoDTO> findAllBySts(String status) {
		return tuninfoRepository.findAllByStsDTO(status);
	}

	@Transactional
	public Long createTunInfo(TunInfoDTO dto) {
		//tunInfo 생성
		TunInfo tuninfo = TunInfo.createTunInfo(dto);
		
		//주문 저장
		tuninfoRepository.save(tuninfo);
		
		return tuninfo.getId(); 				
	}

	@Transactional
	public TunInfo update(long id, TunInfoDTO dto) {
		final TunInfo tuninfo = findById(id);
		tuninfo.updateTunInfo(dto);
		return tuninfo;		
	}
	
}

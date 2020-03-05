package com.tuningboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tuningboard.domain.SvcInfoDTO;
import com.tuningboard.repository.SvcInfoRepository;
import com.tuningboard.service.SvcInfoService;

@RestController
@RequestMapping("/api/svcinfos")
public class SvcInfoRestController {

	@Autowired
	private SvcInfoService svcinfoservice;

	@Autowired
	SvcInfoRepository svcinforepository;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> createSvcInfo(@RequestBody SvcInfoDTO dto){
		svcinfoservice.createSvcInfo(dto);
		//svcinforepository.save(svcinfo);
		return new ResponseEntity<>("{}", HttpStatus.CREATED);		
		}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> updateSvcInfo(@PathVariable("id")Long id, @RequestBody SvcInfoDTO dto){
		svcinfoservice.update(id, dto);
		return new ResponseEntity<>("{}", HttpStatus.OK);		
		}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> deleteSvcInfo(@PathVariable("id") Long id){		
		svcinforepository.deleteById(id);
		return new ResponseEntity<>("{}", HttpStatus.OK);		
		}
		
	}
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

import com.tuningboard.domain.TunInfoDTO;
import com.tuningboard.repository.TunInfoRepository;
import com.tuningboard.service.TunInfoService;

@RestController
@RequestMapping("/api/tuninfos")
public class TunInfoRestController {

	@Autowired
	private TunInfoService tuninfoservice;

	@Autowired
	TunInfoRepository tuninforepository;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> createTunInfo(@RequestBody TunInfoDTO dto){
		tuninfoservice.createTunInfo(dto);
		//tuninforepository.save(tuninfo);
		return new ResponseEntity<>("{}", HttpStatus.CREATED);		
		}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> updateTunInfo(@PathVariable("id")Long id, @RequestBody TunInfoDTO dto){
		tuninfoservice.update(id, dto);
		return new ResponseEntity<>("{}", HttpStatus.OK);		
		}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> deleteTunInfo(@PathVariable("id") Long id){		
		tuninforepository.deleteById(id);
		return new ResponseEntity<>("{}", HttpStatus.OK);		
		}
		
	}
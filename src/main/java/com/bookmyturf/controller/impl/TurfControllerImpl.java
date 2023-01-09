package com.bookmyturf.controller.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyturf.controller.TurfController;
import com.bookmyturf.dto.TurfDTO;
import com.bookmyturf.entity.Turf;
import com.bookmyturf.mapper.TurfMapper;
import com.bookmyturf.service.TurfService;

@RestController
@RequestMapping("api/turf")
public class TurfControllerImpl implements TurfController {
	
	@Autowired
	TurfMapper mapper;
	
	@Autowired
	TurfService service;
	
	private Logger log = LoggerFactory.getLogger(TurfControllerImpl.class);
	
	@Override
	@CrossOrigin("*")
	@PostMapping("/save")
	public TurfDTO save(TurfDTO dto) {
		log.info("turf Dto - "+dto);
		Turf entity = mapper.asEntity(dto);
		log.info("turf entity - "+entity);
		return mapper.asDTO(service.save(entity));
	}

	@Override
	@CrossOrigin("*")
	@PostMapping("/{id}")
	public TurfDTO findById(Integer id) {
		Optional<Turf> turfOpt=service.findById(id);
		if(turfOpt.isPresent())
			return mapper.asDTO(turfOpt.get());
		else
			return mapper.asDTO(new Turf());
	}

	@Override
	@CrossOrigin("*")
	@GetMapping("/search/status/pending")
	public List<TurfDTO> findByapprovalStatus() {
		return mapper.asDTOList(service.findByapprovalStatus("Pending"));
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping("/search/status/available")
	public List<TurfDTO> findByTurfStatusAndApprovalStatus() {
		return mapper.asDTOList(service.findByTurfStatusAndApprovalStatus("Available", "Approved"));
	}
	
	@Override
	@CrossOrigin("*")
	@PostMapping("/update/status")
	public TurfDTO updateApprovalStatus(TurfDTO dto) {
		TurfDTO dtoResponse = findById(dto.getId());
		dtoResponse.setApprovalStatus("Approved");
		return save(dtoResponse);
	}
	
	@Override
	@CrossOrigin("*")
	@PostMapping("/update/status/available")
	public TurfDTO updateAvailabilityStatus(TurfDTO dto) {
		TurfDTO dtoResponse = findById(dto.getId());
		dtoResponse.setTurfStatus("Available");
		return save(dtoResponse);
	}
	
	@Override
	@CrossOrigin("*")
	@PostMapping("/update/status/notavailable")
	public TurfDTO updateAvailabilityStatusN(TurfDTO dto) {
		TurfDTO dtoResponse = findById(dto.getId());
		dtoResponse.setTurfStatus("Not Available");
		return save(dtoResponse);
	}

	@Override
	@CrossOrigin("*")
	@GetMapping("/search/status/unavailable")
	public List<TurfDTO> findByTurfStatus(String turfStatus) {
		return mapper.asDTOList(service.findByTurfStatus("Available"));
	}

}

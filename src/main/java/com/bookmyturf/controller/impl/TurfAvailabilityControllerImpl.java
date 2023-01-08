package com.bookmyturf.controller.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyturf.controller.TurfAvailabilityController;
import com.bookmyturf.dto.TurfAvailabilityDTO;
import com.bookmyturf.entity.TurfAvailability;
import com.bookmyturf.mapper.TurfAvailabilityMapper;
import com.bookmyturf.repository.TurfAvailabilityRepo;
import com.bookmyturf.service.TurfAvailabilityService;

@RestController
@RequestMapping("api/turf/availability")
public class TurfAvailabilityControllerImpl implements TurfAvailabilityController {

	@Autowired
	TurfAvailabilityRepo repo;
	
	@Autowired
	TurfAvailabilityMapper mapper;
	
	@Autowired
	TurfAvailabilityService service;
	
	private Logger log = LoggerFactory.getLogger(TurfAvailabilityControllerImpl.class);
	
	@Override
	@CrossOrigin("*")
	@PostMapping("/save")
	public TurfAvailabilityDTO save(@RequestBody TurfAvailabilityDTO dto) {
		log.info("TurfAvailability Dto - "+dto);
		TurfAvailability entity = mapper.asEntity(dto);
		log.info("TurfAvailability entity - "+entity);
		return mapper.asDTO(service.save(entity));
	}

	@Override
	@CrossOrigin("*")
	@PostMapping("/{id}")
	public TurfAvailabilityDTO findById(String id) {
		Optional<TurfAvailability> turfAvOpt=service.findById(id);
		if(turfAvOpt.isPresent())
			return mapper.asDTO(turfAvOpt.get());
		else
			return mapper.asDTO(new TurfAvailability());
	}

	@Override
	@CrossOrigin("*")
	@GetMapping("/search")
	public List<TurfAvailabilityDTO> findAll() {
		return mapper.asDTOList(service.findAll());
	}

}

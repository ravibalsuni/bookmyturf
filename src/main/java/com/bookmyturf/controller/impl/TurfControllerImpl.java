package com.bookmyturf.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyturf.controller.TurfController;
import com.bookmyturf.dto.TurfDTO;
import com.bookmyturf.entity.Turf;
import com.bookmyturf.mapper.TurfMapper;
import com.bookmyturf.repository.TurfRepository;
import com.bookmyturf.service.TurfService;

@RestController
@RequestMapping("api/turf")
public class TurfControllerImpl implements TurfController {

	@Autowired
	TurfRepository turfRepo;
	
	@Autowired
	TurfMapper turfMapper;
	
	@Autowired
	TurfService turfService;
	
	private Logger log = LoggerFactory.getLogger(TurfControllerImpl.class);
	
	@Override
	@CrossOrigin("*")
	@PostMapping("/save")
	public TurfDTO save(@RequestBody TurfDTO turfDto) {
		log.info("turf Dto - "+turfDto);
		Turf turf = turfMapper.asEntity(turfDto);
		log.info("turf entity - "+turf);
		return turfMapper.asDTO(turfService.save(turf));
	}

}

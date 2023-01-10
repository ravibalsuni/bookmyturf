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

import com.bookmyturf.controller.TurfBookingController;
import com.bookmyturf.dto.TurfBookingDTO;
import com.bookmyturf.entity.TurfBooking;
import com.bookmyturf.mapper.TurfBookingMapper;
import com.bookmyturf.repository.TurfBookingRepo;
import com.bookmyturf.service.TurfBookingService;

@RestController
@RequestMapping("api/turf/booking")
public class TurfBookingControllerImpl implements TurfBookingController {

	@Autowired
	private TurfBookingRepo repo;
	
	@Autowired
	private TurfBookingMapper mapper;
	
	@Autowired
	private TurfBookingService service;
	
	private Logger log = LoggerFactory.getLogger(TurfBookingControllerImpl.class);
	
	@Override
	@CrossOrigin("*")
	@PostMapping("/save")
	public TurfBookingDTO save(@RequestBody TurfBookingDTO dto) {
		log.info("TurfBooking Dto - "+dto);
		TurfBooking entity = mapper.asEntity(dto);
		log.info("turfBooking entity - "+entity);
		return mapper.asDTO(service.save(entity));
	}

	@Override
	@CrossOrigin("*")
	@PostMapping("/{id}")
	public TurfBookingDTO findById(String id) {
		Optional<TurfBooking> turfBookingOpt=service.findById(id);
		if(turfBookingOpt.isPresent())
			return mapper.asDTO(turfBookingOpt.get());
		else
			return mapper.asDTO(new TurfBooking());
	}

	@Override
	@CrossOrigin("*")
	@GetMapping("/search")
	public List<TurfBookingDTO> findAll() {
		return mapper.asDTOList(service.findAll());
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping("/search/createdby")
	public List<TurfBookingDTO> findByCreatedBy(String createdBy) {
		return mapper.asDTOList(service.findBycreatedBy(createdBy));
	}

	@Override
	@CrossOrigin("*")
	@GetMapping("/search/bookingstatus")
	public List<TurfBookingDTO> findBycreatedByAndBookingStatus(String createdBy,String bookingStatus) {
		return mapper.asDTOList(service.findBycreatedByAndBookingStatus(bookingStatus, createdBy));
	}

}

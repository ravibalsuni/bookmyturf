package com.bookmyturf.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import com.bookmyturf.dto.TurfBookingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Turf Booking API")
@Validated
public interface TurfBookingController {
	
	@ApiOperation("add new data")
	TurfBookingDTO save(@RequestBody TurfBookingDTO dto);
	
	@ApiOperation("find by id")
	TurfBookingDTO findById(@Param("id") String id);
	
	@ApiOperation("find all")
	List<TurfBookingDTO> findAll();	
	
	@ApiOperation("find by created by")
	List<TurfBookingDTO>findByCreatedBy(@Param("createdby")String createdBy);
}

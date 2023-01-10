package com.bookmyturf.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.bookmyturf.dto.TurfBookingDTO;
import com.bookmyturf.dto.TurfDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Turf Booking API")
@Validated
public interface TurfBookingController {
	
	@ApiOperation("add new data")
	TurfBookingDTO save(@RequestBody TurfBookingDTO dto);
	
	@ApiOperation("find by id")
	TurfBookingDTO findById(@PathVariable("id") Integer id);
	
	@ApiOperation("find all")
	List<TurfBookingDTO> findAll();	
	
	@ApiOperation("find by created by")
	List<TurfBookingDTO> findByCreatedBy(@Param("createdby")String createdBy);
	
	@ApiOperation("find by booking status and created by")
	List<TurfBookingDTO> findBycreatedByAndBookingStatus(@Param("createdby")String createdBy, @Param("bookingstatus")String bookingStatus);
	
	@ApiOperation("find by approval status")
	List<TurfBookingDTO> findByBookingStatus();
	
	@ApiOperation("Update turf booking status")
	TurfBookingDTO updateApprovalStatus(@RequestBody TurfBookingDTO dto);
}

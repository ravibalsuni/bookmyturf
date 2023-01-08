package com.bookmyturf.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import com.bookmyturf.dto.TurfAvailabilityDTO;
import com.bookmyturf.dto.TurfDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Turf Availability API")
@Validated
public interface TurfAvailabilityController {
	
	@ApiOperation("add new data")
	TurfAvailabilityDTO save(@RequestBody TurfAvailabilityDTO dto);
	
	@ApiOperation("find by id")
	TurfAvailabilityDTO findById(@Param("id") String id);
	
	@ApiOperation("find all")
	List<TurfAvailabilityDTO> findAll();	
}

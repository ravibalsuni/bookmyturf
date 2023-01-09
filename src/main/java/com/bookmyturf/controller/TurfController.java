package com.bookmyturf.controller;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.bookmyturf.dto.TurfDTO;
import com.bookmyturf.entity.Turf;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Turf API")
@Validated
public interface TurfController {
	
	@ApiOperation("add new data")
	TurfDTO save(@RequestBody TurfDTO dto);
	
	@ApiOperation("find by id")
	TurfDTO findById(@PathVariable("id") Integer id);
	
	@ApiOperation("find by approval status")
	List<TurfDTO> findByapprovalStatus();
	
	@ApiOperation("Update turf approval status")
	TurfDTO updateApprovalStatus(@RequestBody TurfDTO dto);

	@ApiOperation("find by available and approved status")
	List<TurfDTO> findByTurfStatusAndApprovalStatus();
	
	@ApiOperation("find by turf status")
	List<TurfDTO> findByTurfStatus(String turfStatus);

	@ApiOperation("update turf availability to Available")
	TurfDTO updateAvailabilityStatus(@RequestBody TurfDTO dto);

	@ApiOperation("update turf availability to Not Available")
	TurfDTO updateAvailabilityStatusN(@RequestBody TurfDTO dto);
	
}

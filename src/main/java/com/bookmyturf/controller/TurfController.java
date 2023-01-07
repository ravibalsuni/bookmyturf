package com.bookmyturf.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.bookmyturf.dto.TurfDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Turf API")
public interface TurfController {
	
	@ApiOperation("add new data")
	TurfDTO save(@RequestBody TurfDTO turf);
}

package com.bookmyturf.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
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
	TurfDTO findById(@Param("id") Integer id);
	
	@ApiOperation("find all")
	List<TurfDTO> findAll();	
	
}

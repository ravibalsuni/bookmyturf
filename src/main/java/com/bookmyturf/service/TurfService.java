package com.bookmyturf.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookmyturf.entity.Turf;

public interface TurfService extends GenericService<Turf, Integer> {
	
	Page<Turf> search(Map<String, String> searchCriteria, Pageable pageable);

}

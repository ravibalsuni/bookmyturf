package com.bookmyturf.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookmyturf.entity.TurfAvailability;

public interface TurfAvailabilityService extends GenericService<TurfAvailability, String> {
	
	Page<TurfAvailability> search(Map<String, String> searchCriteria, Pageable pageable);

}

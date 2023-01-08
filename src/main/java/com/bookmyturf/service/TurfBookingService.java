package com.bookmyturf.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookmyturf.entity.TurfBooking;

public interface TurfBookingService extends GenericService<TurfBooking, String> {
	
	Page<TurfBooking> search(Map<String, String> searchCriteria, Pageable pageable);

}

package com.bookmyturf.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookmyturf.dto.TurfBookingDTO;
import com.bookmyturf.entity.TurfBooking;

public interface TurfBookingService extends GenericService<TurfBooking, Integer> {
	
	Page<TurfBooking> search(Map<String, String> searchCriteria, Pageable pageable);
	List<TurfBooking> findBycreatedBy(String createdBy);
	List<TurfBooking>findBycreatedByAndBookingStatus(String bookingStatus,String createdBy);
	List<TurfBooking> findByBookingStatus(String bookingStatus);

}

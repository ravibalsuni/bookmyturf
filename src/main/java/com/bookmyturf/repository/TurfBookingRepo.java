package com.bookmyturf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bookmyturf.entity.TurfBooking;

@Repository
public interface TurfBookingRepo extends JpaRepository<TurfBooking, String>, JpaSpecificationExecutor<TurfBooking>{
	List<TurfBooking> findBycreatedBy(String createdBy);
}

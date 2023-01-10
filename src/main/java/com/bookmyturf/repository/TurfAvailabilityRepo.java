package com.bookmyturf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bookmyturf.entity.Turf;
import com.bookmyturf.entity.TurfAvailability;

@Repository
public interface TurfAvailabilityRepo extends JpaRepository<TurfAvailability, String>, JpaSpecificationExecutor<Turf>{

}

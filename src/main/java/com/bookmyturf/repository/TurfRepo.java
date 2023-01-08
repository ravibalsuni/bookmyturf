package com.bookmyturf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bookmyturf.entity.Turf;

@Repository
public interface TurfRepo extends JpaRepository<Turf, Integer>, JpaSpecificationExecutor<Turf>{
	List<Turf> findByApprovalStatus(String approvalStatus);
	List<Turf> findByTurfStatusAndApprovalStatus(String turfStatus, String approvalStatus);
}

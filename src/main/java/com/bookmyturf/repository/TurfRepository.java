package com.bookmyturf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bookmyturf.entity.Turf;

@Repository
public interface TurfRepository extends JpaRepository<Turf, Integer>, JpaSpecificationExecutor<Turf>{

}

package com.bookmyturf.service.impl;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookmyturf.dto.TurfDTO;
import com.bookmyturf.entity.Turf;
import com.bookmyturf.repository.TurfRepo;
import com.bookmyturf.service.TurfService;

@Service
@Transactional
public class TurfServiceImpl implements TurfService {
	
	@Autowired
	private TurfRepo turfRepo;
	
	private Set<String> staticSearchableFields;
	
	@PostConstruct
	public void init() {
		staticSearchableFields = getAllFileds(Turf.class);
	}

	private Set<String> getAllFileds(final Class<?> type) {
		Set<String> fields = new HashSet<>();
		for(Field field : type.getDeclaredFields()) {
			fields.add(field.getName());
		}
		
		if(type.getSuperclass() != null)
			fields.addAll(getAllFileds(type.getSuperclass()));
		return fields;
	}

	@Override
	public Turf save(Turf entity) {
		return turfRepo.save(entity);
	}

	@Override
	public List<Turf> save(List<Turf> entities) {
		return turfRepo.saveAll(entities);
	}

	@Override
	public void deleteById(Integer id) {
		turfRepo.deleteById(id);		
	}

	@Override
	public Optional<Turf> findById(Integer id) {
		return turfRepo.findById(id);
	}

	@Override
	public List<Turf> findAll() {
		return turfRepo.findAll();
	}

	@Override
	public Page<Turf> findAll(Pageable pageable) {
		return turfRepo.findAll(pageable);
	}

	@Override
	public Turf update(Turf entity, Integer id) {
		Optional<Turf> optionalTurf = findById(id);
		if(optionalTurf.isPresent())
			return turfRepo.save(entity);
		else
			return null;
	}

	@Override
	public Page<Turf> search(Map<String, String> searchCriteria, Pageable pageable) {
		
		return null;
	}

	@Override
	public List<Turf> findByapprovalStatus(String approvalStatus) {
		return turfRepo.findByApprovalStatus(approvalStatus);
	}

	@Override
	public List<Turf> findByTurfStatusAndApprovalStatus(String turfStatus, String approvalStatus) {
		return turfRepo.findByTurfStatusAndApprovalStatus(turfStatus, approvalStatus);
	}

	@Override
	public List<Turf> findByTurfStatus(String turfStatus) {
		return turfRepo.findByTurfStatus(turfStatus);
	}

}

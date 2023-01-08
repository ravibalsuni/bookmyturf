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

import com.bookmyturf.entity.TurfAvailability;
import com.bookmyturf.entity.TurfBooking;
import com.bookmyturf.repository.TurfAvailabilityRepo;
import com.bookmyturf.service.TurfAvailabilityService;

@Service
@Transactional
public class TurfAvailabilityServiceImpl implements TurfAvailabilityService {
	
	@Autowired
	private TurfAvailabilityRepo repo;
	
	private Set<String> staticSearchableFields;
	
	@PostConstruct
	public void init() {
		staticSearchableFields = getAllFileds(TurfBooking.class);
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
	public TurfAvailability save(TurfAvailability entity) {
		return repo.save(entity);
	}

	@Override
	public List<TurfAvailability> save(List<TurfAvailability> entities) {
		return repo.saveAll(entities);
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);		
	}

	@Override
	public Optional<TurfAvailability> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public List<TurfAvailability> findAll() {
		return repo.findAll();
	}

	@Override
	public Page<TurfAvailability> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public TurfAvailability update(TurfAvailability entity, String id) {
		Optional<TurfAvailability> optionalTurfAvailability = findById(id);
		if(optionalTurfAvailability.isPresent())
			return repo.save(entity);
		else
			return null;
	}

	@Override
	public Page<TurfAvailability> search(Map<String, String> searchCriteria, Pageable pageable) {
		return null;
	}
}

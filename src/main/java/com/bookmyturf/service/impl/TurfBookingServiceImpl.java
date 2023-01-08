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

import com.bookmyturf.entity.TurfBooking;
import com.bookmyturf.repository.TurfBookingRepo;
import com.bookmyturf.service.TurfBookingService;

@Service
@Transactional
public class TurfBookingServiceImpl implements TurfBookingService {
	
	@Autowired
	private TurfBookingRepo repo;
	
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
	public TurfBooking save(TurfBooking entity) {
		return repo.save(entity);
	}

	@Override
	public List<TurfBooking> save(List<TurfBooking> entities) {
		return repo.saveAll(entities);
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);		
	}

	@Override
	public Optional<TurfBooking> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public List<TurfBooking> findAll() {
		return repo.findAll();
	}

	@Override
	public Page<TurfBooking> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public TurfBooking update(TurfBooking entity, String id) {
		Optional<TurfBooking> optionalTurfBooking = findById(id);
		if(optionalTurfBooking.isPresent())
			return repo.save(entity);
		else
			return null;
	}

	@Override
	public Page<TurfBooking> search(Map<String, String> searchCriteria, Pageable pageable) {
		return null;
	}
}

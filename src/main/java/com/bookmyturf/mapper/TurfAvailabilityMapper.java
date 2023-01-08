package com.bookmyturf.mapper;

import org.mapstruct.Mapper;

import com.bookmyturf.dto.TurfAvailabilityDTO;
import com.bookmyturf.entity.TurfAvailability;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface TurfAvailabilityMapper extends GenericMapper<TurfAvailability, TurfAvailabilityDTO> {

	@Override
	TurfAvailability asEntity(TurfAvailabilityDTO dto);
	
	@Override
	TurfAvailabilityDTO asDTO(TurfAvailability entity);
}
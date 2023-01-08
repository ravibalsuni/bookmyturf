package com.bookmyturf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookmyturf.dto.TurfDTO;
import com.bookmyturf.entity.Turf;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface TurfMapper extends GenericMapper<Turf, TurfDTO> {

	@Override
	Turf asEntity(TurfDTO dto);
	
	@Override
	TurfDTO asDTO(Turf entity);
}
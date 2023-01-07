package com.bookmyturf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bookmyturf.dto.TurfDTO;
import com.bookmyturf.entity.Turf;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface TurfMapper extends GenericMapper<Turf, TurfDTO> {

	@Override
	@Mapping(target = "id")
	Turf asEntity(TurfDTO dto);
	
	@Override
	@Mapping(target = "id")
	TurfDTO asDTO(Turf entity);
}
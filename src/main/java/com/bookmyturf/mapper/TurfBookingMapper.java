package com.bookmyturf.mapper;

import org.mapstruct.Mapper;
import com.bookmyturf.dto.TurfBookingDTO;
import com.bookmyturf.entity.TurfBooking;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface TurfBookingMapper extends GenericMapper<TurfBooking, TurfBookingDTO> {

	@Override
	TurfBooking asEntity(TurfBookingDTO dto);
	
	@Override
	TurfBookingDTO asDTO(TurfBooking entity);
}
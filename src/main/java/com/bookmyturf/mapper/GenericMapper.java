package com.bookmyturf.mapper;

import java.util.List;

public interface GenericMapper<E,D> {
	E asEntity(D dto);
	D asDTO(E asEntity);
	
	List<E> asEntityList(List<D> dto);
	List<D> asDTOList(List<E> asEntity);
}

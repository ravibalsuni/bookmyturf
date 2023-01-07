package com.bookmyturf.mapper;

import javax.persistence.EntityManager;

import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import com.bookmyturf.dto.AbstractDTO;
import com.bookmyturf.entity.AbstractEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReferenceMapper {

	private final EntityManager em;

	public ReferenceMapper(EntityManager em) {
		super();
		this.em = em;
	}
	
	@ObjectFactory
	public<T extends AbstractEntity<?>> T resolve(AbstractDTO<?> sourceDTO, @TargetType Class<T> type){
		T entity = null;
		if(sourceDTO.getId()!=null)
			entity = em.find(type, sourceDTO.getId());
		try {
			if(entity ==  null) {
				entity = type.getDeclaredConstructor().newInstance();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return entity;
	}
}

package com.bookmyturf.dto;

public abstract class AbstractDTO<E> {
	protected E id;

	public E getId() {
		return id;
	}

	public void setId(E id) {
		this.id = id;
	}
	
}

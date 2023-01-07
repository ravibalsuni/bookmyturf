package com.bookmyturf.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turfBooking")
public class TurfBooking {

	@Id
	@Column(name="bookingId")
	private String bookingId;
	@Column(name="turfId")
	private String turfId;
	@Column(name="createdDateTime")
	private Date createdDateTime;
	@Column(name="bookingDateTime")
	private Date bookingDateTime;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="bookingStatus")
	private String bookingStatus;
}

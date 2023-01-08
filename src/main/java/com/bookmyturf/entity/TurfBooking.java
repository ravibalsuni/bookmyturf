package com.bookmyturf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turfBooking")
public class TurfBooking {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="turf_id")
	private String turfId;
	
	@Column(name="created_datetime")
	private String createdDateTime;
	
	@Column(name="booking_datetime")
	private String bookingDateTime;
	
	@Column(name="booking_date")
	private String bookingDate;
	
	@Column(name="booking_timeslot")
	private String bookingTimeslot;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="booking_status")
	private String bookingStatus;
	
	@Column(name="availability_status")
	private String availabilityStatus;
	
	@Column(name="duration")
	private String duration;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTurfId() {
		return turfId;
	}

	public void setTurfId(String turfId) {
		this.turfId = turfId;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(String bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingTimeslot() {
		return bookingTimeslot;
	}

	public void setBookingTimeslot(String bookingTimeslot) {
		this.bookingTimeslot = bookingTimeslot;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "TurfBooking [id=" + id + ", turfId=" + turfId + ", createdDateTime=" + createdDateTime
				+ ", bookingDateTime=" + bookingDateTime + ", bookingDate=" + bookingDate + ", bookingTimeslot="
				+ bookingTimeslot + ", createdBy=" + createdBy + ", bookingStatus=" + bookingStatus
				+ ", availabilityStatus=" + availabilityStatus + ", duration=" + duration + "]";
	}
}

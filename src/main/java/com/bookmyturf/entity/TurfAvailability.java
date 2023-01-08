package com.bookmyturf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turfAvailability")
public class TurfAvailability {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="turf_id")
	private String turfId;
	
	@Column(name="available_date")
	private String availableDate;
	
	@Column(name="available_time")
	private String availableTime;
	
	@Column(name="availability_status")
	private String availabilityStatus;
	
	
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


	public String getAvailableDate() {
		return availableDate;
	}


	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}


	public String getAvailableTime() {
		return availableTime;
	}


	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}


	public String getAvailabilityStatus() {
		return availabilityStatus;
	}


	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}


	@Override
	public String toString() {
		return "TurfAvailability [id=" + id + ", turfId=" + turfId + ", availableDate=" + availableDate
				+ ", availableTime=" + availableTime + ", availabilityStatus=" + availabilityStatus + "]";
	}
	
	
	
}

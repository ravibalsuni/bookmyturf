package com.bookmyturf.dto;

public class TurfAvailabilityDTO extends AbstractDTO<Integer> {
	
	private String turfId;
	private String availableDate;
	private String availableTime;
	private String availabilityStatus;
	
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
		return "TurfAvailabilityDTO [turfId=" + turfId + ", availableDate=" + availableDate + ", availableTime="
				+ availableTime + ", availabilityStatus=" + availabilityStatus + "]";
	}
	
	
}

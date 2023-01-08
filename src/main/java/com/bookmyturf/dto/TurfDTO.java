package com.bookmyturf.dto;

public class TurfDTO extends AbstractDTO<Integer> {
	
	private String name;
	private String pin;
	private String address;
	private String ownerId;
	private String turfStatus;
	private String approvalStatus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getTurfStatus() {
		return turfStatus;
	}
	public void setTurfStatus(String turfStatus) {
		this.turfStatus = turfStatus;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	@Override
	public String toString() {
		return "TurfDTO [name=" + name + ", pin=" + pin + ", address=" + address + ", ownerId=" + ownerId
				+ ", turfStatus=" + turfStatus + ", approvalStatus=" + approvalStatus + "]";
	}
	
}

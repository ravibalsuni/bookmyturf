package com.bookmyturf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turf")
public class Turf implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="pin")
	private String pin;
	@Column(name="address")
	private String address;
	@Column(name="owner_id")
	private String  ownerId;
	@Column(name="turf_status")
	private String turfStatus;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Turf [turfId=" + id + ", name=" + name + ", pin=" + pin + ", address=" + address + ", ownerId="
				+ ownerId + ", turfStatus=" + turfStatus + "]";
	}
}

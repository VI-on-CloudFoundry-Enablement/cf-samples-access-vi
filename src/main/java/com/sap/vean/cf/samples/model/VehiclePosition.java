package com.sap.vean.cf.samples.model;

import java.util.GregorianCalendar;

public class VehiclePosition {

	private String vehicleUID;
	private String vehicleID;
	private String vehicleName;
	private GregorianCalendar PointInTime;
	private String position;
	
	public String getVehicleUID() {
		return vehicleUID;
	}
	public void setVehicleUID(String vehicleUID) {
		this.vehicleUID = vehicleUID;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public GregorianCalendar getPointInTime() {
		return PointInTime;
	}
	public void setPointInTime(GregorianCalendar gregorianCalendar) {
		PointInTime = gregorianCalendar;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}

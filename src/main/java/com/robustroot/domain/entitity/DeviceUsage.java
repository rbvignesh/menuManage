package com.robustroot.domain.entitity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class DeviceUsage {
	@EmbeddedId
	DeviceUsageKey deviceUsageKey;
	//TODO:: Order and Branch Relationship
	@MapsId("tenantId") 
	@ManyToOne
	@JoinColumn(name = "tenant_id")
	Tenant tenant;
	
	@MapsId("deviceId") 
	@ManyToOne
	@JoinColumn(name = "device_id")
	Device device;
	@Column(name = "created_by")
	String createdBy;
	@Column(name = "created_on")
	Timestamp createdOn;
	@Column(name = "last_updated_by")
	String lastUpdatedBy;
	@Column(name = "last_updated_on")
	Timestamp lastUpdatedOn;
	
	public DeviceUsage() {
	}

	public DeviceUsage(DeviceUsageKey deviceUsageKey, Tenant tenant, Device device, String createdBy,
			Timestamp createdOn, String lastUpdatedBy, Timestamp lastUpdatedOn) {
		super();
		this.deviceUsageKey = deviceUsageKey;
		this.tenant = tenant;
		this.device = device;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	
	
}

package com.robustroot.domain.entitity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DeviceUsageKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//TODO:: Order and Branch Relationship
		@Column(name = "tenant_id")
		Long  tenantId;
		@Column(name = "device_id")
		Long deviceId;
}

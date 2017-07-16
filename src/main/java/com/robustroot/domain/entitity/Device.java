package com.robustroot.domain.entitity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import lombok.Builder;
import lombok.Data;
@Data
@Entity
@Builder
public class Device {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "device_id")
	Long deviceId;
	//TODO:: Correct Relationship
	/*@Column(name = "branch_id")
	Long branchId;*/
	@ManyToOne
	@JoinColumn(name = "tenant_id")
	Tenant tenant;
	@Column(name = "commissioned_date")
	Timestamp commissionedDate;
	@Column(name = "retired_date")
	Timestamp retiredDate;
	@Column(name = "created_by")
	String createdBy;
	@Column(name = "created_on")
	Timestamp createdOn;
	@Column(name = "last_updated_by")
	String lastUpdatedBy;
	@Column(name = "last_updated_on")
	Timestamp lastUpdatedOn;
	
	public Device() {
	}

	public Device(Long deviceId, Tenant tenant, Timestamp commissionedDate, Timestamp retiredDate, String createdBy,
			Timestamp createdOn, String lastUpdatedBy, Timestamp lastUpdatedOn) {
		super();
		this.deviceId = deviceId;
		this.tenant = tenant;
		this.commissionedDate = commissionedDate;
		this.retiredDate = retiredDate;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	
	
	
	
}

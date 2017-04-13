package com.robustroot.service.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonAutoDetect
public class TenantDTO {
	Long tenantId;
	String name;
	String displayName;
	String billingAddress;
	String email;
	String telNumber;
	String mobileNumber;
	Long logoImageId;
	String status;
	String createdBy;
	Timestamp createdOn;
	String lastUpdatedBy;
	Timestamp lastUpdatedOn;
	

	public TenantDTO(){
		
	}

	public TenantDTO(Long tenantId, String name, String displayName, String billingAddress, String email, String telNumber,
			String mobileNumber, Long logoImageId, String status, String createdBy, Timestamp createdOn,
			String lastUpdatedBy, Timestamp lastUpdatedOn) {
		super();
		this.tenantId = tenantId;
		this.name = name;
		this.displayName = displayName;
		this.billingAddress = billingAddress;
		this.email = email;
		this.telNumber = telNumber;
		this.mobileNumber = mobileNumber;
		this.logoImageId = logoImageId;
		this.status = status;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedOn = lastUpdatedOn;
	}

		
	

}

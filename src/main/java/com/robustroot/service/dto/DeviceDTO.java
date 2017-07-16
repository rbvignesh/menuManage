package com.robustroot.service.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceDTO {
	Long deviceId;
	Long branchId;
	Long tenantId;
	Timestamp commissionedDate;
	Timestamp retiredDate;
	String createdBy;
	Timestamp createdOn;
	String lastUpdatedBy;
	Timestamp lastUpdatedOn;
	
	public DeviceDTO(Long deviceId, Long branchId, Long tenantId, Timestamp commissionedDate, Timestamp retiredDate,
			String createdBy, Timestamp createdOn, String lastUpdatedBy, Timestamp lastUpdatedOn) {
		super();
		this.deviceId = deviceId;
		this.branchId = branchId;
		this.tenantId = tenantId;
		this.commissionedDate = commissionedDate;
		this.retiredDate = retiredDate;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedOn = lastUpdatedOn;
	}

}

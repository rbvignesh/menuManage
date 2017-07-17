package com.robustroot.service.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class DeviceUsageDTO {
	Long tenantId;
	//Long branchId;
	Long deviceId;
	//Long orderId;
	String createdBy;
	Timestamp createdOn;
	String lastUpdatedBy;
	Timestamp lastUpdatedOn;
	
	

}

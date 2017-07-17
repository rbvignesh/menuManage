package com.robustroot.domain.entitity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Tenant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "tenant_id")
	Long tenantId;
	String name;
	@Column(name = "display_name")
	String displayName;
	@Column(name = "billing_address")
	String billingAddress;
	String email;
	@Column(name = "tel_number")
	String telNumber;
	@Column(name = "mobile_number")
	String mobileNumber;
	@Column(name = "logo_image_id")
	Long logoImageId;
	String status;
	@Column(name = "created_by")
	String createdBy;
	@Column(name = "created_on")
	Timestamp createdOn;
	@Column(name = "last_updated_by")
	String lastUpdatedBy;
	@Column(name = "last_updated_on")
	Timestamp lastUpdatedOn;
	
	@SuppressWarnings("unused")
	public Tenant(){}
	
	public Tenant(Long tenantId){this.tenantId = tenantId;}

	public Tenant(Long tenantId, String name, String displayName, String billingAddress, String email, String telNumber,
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

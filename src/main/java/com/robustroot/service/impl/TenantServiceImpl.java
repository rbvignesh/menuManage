package com.robustroot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustroot.domain.entitity.Tenant;
import com.robustroot.domain.repository.TenantRepository;
import com.robustroot.service.TenantService;
import com.robustroot.service.dto.TenantDTO;
@Service
public class TenantServiceImpl implements TenantService {

	@Autowired
	TenantRepository tenantRepository;

	@Override
	public Long createTenant(TenantDTO tenantDTO) {
		Tenant tenant = Tenant.builder().name(tenantDTO.getName()).billingAddress(tenantDTO.getBillingAddress()).email(tenantDTO.getEmail())
				.telNumber(tenantDTO.getTelNumber()).logoImageId(tenantDTO.getLogoImageId()).status(tenantDTO.getStatus())
				.createdBy(tenantDTO.getCreatedBy()).createdOn(tenantDTO.getCreatedOn())
				.lastUpdatedBy(tenantDTO.getLastUpdatedBy()).lastUpdatedOn(tenantDTO.getLastUpdatedOn()).build();
		tenantRepository.save(tenant);
		return tenant.getTenantId();
	}

}

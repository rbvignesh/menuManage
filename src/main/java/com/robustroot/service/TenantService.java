package com.robustroot.service;

import com.robustroot.service.dto.TenantDTO;
public interface TenantService {

	public Long createTenant(TenantDTO tenantDTO);
}
package com.robustroot.service;

import java.util.List;

import com.robustroot.service.dto.TenantDTO;
public interface TenantService {

	public Long createTenant(TenantDTO tenantDTO);
	
	public List<TenantDTO> fetchAllTenants();
}

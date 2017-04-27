package com.robustroot.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public Long create(TenantDTO tenantDTO) {
		Tenant tenant = Tenant.builder().name(tenantDTO.getName()).billingAddress(tenantDTO.getBillingAddress()).email(tenantDTO.getEmail())
				.telNumber(tenantDTO.getTelNumber()).logoImageId(tenantDTO.getLogoImageId()).status(tenantDTO.getStatus())
				.createdBy(tenantDTO.getCreatedBy()).createdOn(tenantDTO.getCreatedOn())
				.lastUpdatedBy(tenantDTO.getLastUpdatedBy()).lastUpdatedOn(tenantDTO.getLastUpdatedOn()).build();
		tenantRepository.save(tenant);
		return tenant.getTenantId();
	}

	@Override
	public List<TenantDTO> fetchAll() {
		List<TenantDTO> tenantDTOList = null;
		List<Tenant> tenantEntityList = tenantRepository.findAll();
		for(Tenant tenant: tenantEntityList){
			if(tenantDTOList == null)
				tenantDTOList = new ArrayList<>();
			TenantDTO tenantDTO = TenantDTO.builder().name(tenant.getName()).billingAddress(tenant.getBillingAddress()).email(tenant.getEmail())
					.telNumber(tenant.getTelNumber()).logoImageId(tenant.getLogoImageId()).status(tenant.getStatus())
					.createdBy(tenant.getCreatedBy()).createdOn(tenant.getCreatedOn())
					.lastUpdatedBy(tenant.getLastUpdatedBy()).lastUpdatedOn(tenant.getLastUpdatedOn()).build();
			tenantDTOList.add(tenantDTO);
		}
		return tenantDTOList;
	}

	@Override
	public TenantDTO fetch(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(TenantDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long delete(TenantDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}

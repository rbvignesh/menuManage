package com.robustroot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustroot.domain.entitity.Device;
import com.robustroot.domain.entitity.Tenant;
import com.robustroot.domain.repository.DeviceRepository;
import com.robustroot.service.DeviceService;
import com.robustroot.service.dto.DeviceDTO;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepository repository;

	@Override
	public Long create(DeviceDTO dto) {
		Device device = Device.builder().commissionedDate(dto.getCommissionedDate()).createdBy(dto.getCreatedBy())
				.createdOn(dto.getCreatedOn()).lastUpdatedBy(dto.getLastUpdatedBy())
				.lastUpdatedOn(dto.getLastUpdatedOn()).retiredDate(dto.getRetiredDate())
				.tenant(new Tenant(dto.getTenantId())).build();
		repository.save(device);
		return device.getDeviceId();
	}

	@Override
	public List<DeviceDTO> fetchAll() {
		List<DeviceDTO> dTOList = null;
		List<Device> entityList = repository.findAll();
		if (entityList != null) {
			dTOList = entityList.stream()
					.map(device -> DeviceDTO.builder().commissionedDate(device.getCommissionedDate())
							.createdBy(device.getCreatedBy()).createdOn(device.getCreatedOn())
							.deviceId(device.getDeviceId()).lastUpdatedBy(device.getLastUpdatedBy())
							.lastUpdatedOn(device.getLastUpdatedOn()).retiredDate(device.getRetiredDate())
							.tenantId(device.getTenant().getTenantId()).build())
					.collect(Collectors.toList());
		}

		return dTOList;
	}

	@Override
	public DeviceDTO fetch(Long id) {
		DeviceDTO dTO = null;
		Device entity = repository.findOne(id);
		if(entity!=null)
			dTO= DeviceDTO.builder().commissionedDate(entity.getCommissionedDate())
			.createdBy(entity.getCreatedBy()).createdOn(entity.getCreatedOn())
			.deviceId(entity.getDeviceId()).lastUpdatedBy(entity.getLastUpdatedBy())
			.lastUpdatedOn(entity.getLastUpdatedOn()).retiredDate(entity.getRetiredDate())
			.tenantId(entity.getTenant().getTenantId()).build();
		return dTO;
	}

	@Override
	public Long update(DeviceDTO dto) {
		Device device = Device.builder().deviceId(dto.getDeviceId()).commissionedDate(dto.getCommissionedDate()).createdBy(dto.getCreatedBy())
				.createdOn(dto.getCreatedOn()).lastUpdatedBy(dto.getLastUpdatedBy())
				.lastUpdatedOn(dto.getLastUpdatedOn()).retiredDate(dto.getRetiredDate())
				.tenant(new Tenant(dto.getTenantId())).build();
		repository.save(device);
		return device.getDeviceId();
	}

	@Override
	public Long delete(DeviceDTO dto) {
		Device device = Device.builder().deviceId(dto.getDeviceId()).commissionedDate(dto.getCommissionedDate()).createdBy(dto.getCreatedBy())
				.createdOn(dto.getCreatedOn()).lastUpdatedBy(dto.getLastUpdatedBy())
				.lastUpdatedOn(dto.getLastUpdatedOn()).retiredDate(dto.getRetiredDate())
				.tenant(new Tenant(dto.getTenantId())).build();
		repository.delete(device);
		return dto.getDeviceId();
	}

}

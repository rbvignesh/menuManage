package com.robustroot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustroot.domain.entitity.DeviceUsage;
import com.robustroot.domain.repository.DeviceUsageRepository;
import com.robustroot.service.DeviceUsageService;
import com.robustroot.service.dto.DeviceUsageDTO;

@Service
public class DeviceUsageServiceImpl implements DeviceUsageService {

	@Autowired
	DeviceUsageRepository repository;
	ModelMapper mapper = new ModelMapper();

	@Override
	public Long create(DeviceUsageDTO dto) {
		DeviceUsage deviceUsage = mapper.map(dto, DeviceUsage.class);
		repository.save(deviceUsage);
		return -1L;
	}

	@Override
	public List<DeviceUsageDTO> fetchAll() {
		List<DeviceUsageDTO> dTOList = null;
		List<DeviceUsage> entityList = repository.findAll();
		if (entityList != null) {
			dTOList = entityList.stream()
					.map(device -> mapper.map(device, DeviceUsageDTO.class))
					.collect(Collectors.toList());
		}

		return dTOList;
	}

	@Override
	public DeviceUsageDTO fetch(Long id) {
		DeviceUsageDTO dTO = null;
		DeviceUsage entity = repository.findOne(id);
		if(entity!=null)
			dTO= mapper.map(entity, DeviceUsageDTO.class);
		return dTO;
	}

	@Override
	public Long update(DeviceUsageDTO dto) {
		DeviceUsage deviceUsage = mapper.map(dto, DeviceUsage.class);
		repository.save(deviceUsage);
		return -1L;
	}

	@Override
	public Long delete(DeviceUsageDTO dto) {
		DeviceUsage deviceUsage = mapper.map(dto, DeviceUsage.class);
		repository.delete(deviceUsage);
		return -1L;
	}

}

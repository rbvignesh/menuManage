package com.robustroot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustroot.domain.entitity.Device;
import com.robustroot.domain.repository.DeviceRepository;
import com.robustroot.service.DeviceService;
import com.robustroot.service.dto.DeviceDTO;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepository repository;
	ModelMapper mapper = new ModelMapper();

	@Override
	public Long create(DeviceDTO dto) {
		Device device = mapper.map(dto, Device.class);
		repository.save(device);
		return device.getDeviceId();
	}

	@Override
	public List<DeviceDTO> fetchAll() {
		List<DeviceDTO> dTOList = null;
		List<Device> entityList = repository.findAll();
		if (entityList != null) {
			dTOList = entityList.stream()
					.map(device -> mapper.map(device, DeviceDTO.class))
					.collect(Collectors.toList());
		}

		return dTOList;
	}

	@Override
	public DeviceDTO fetch(Long id) {
		DeviceDTO dTO = null;
		Device entity = repository.findOne(id);
		if(entity!=null)
			dTO= mapper.map(entity, DeviceDTO.class);
		return dTO;
	}

	@Override
	public Long update(DeviceDTO dto) {
		Device device = mapper.map(dto, Device.class);
		repository.save(device);
		return device.getDeviceId();
	}

	@Override
	public Long delete(DeviceDTO dto) {
		Device device = mapper.map(dto, Device.class);
		repository.delete(device);
		return dto.getDeviceId();
	}

}

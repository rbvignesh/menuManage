package com.robustroot.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robustroot.domain.entitity.Device;



@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
package com.robustroot.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robustroot.domain.entitity.DeviceUsage;



@Repository
public interface DeviceUsageRepository extends JpaRepository<DeviceUsage, Long> {
}
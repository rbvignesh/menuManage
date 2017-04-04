package com.robustroot.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robustroot.domain.entitity.Tenant;



@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
	List<Tenant> findByStatus(String status);
}
package com.robustroot.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.robustroot.domain.entitity.Tenant;



@RepositoryRestResource
@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {
	List<Tenant> findByStatus(@Param("s") String status);
}
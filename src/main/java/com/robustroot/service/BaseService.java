package com.robustroot.service;

import java.util.List;

public interface BaseService<T> {

	public Long create(T dto);
	
	public List<T> fetchAll();
	
	public T fetch(Long id);
	
	public Long update(T dto);
	
	
	public Long delete(T dto);
	
}

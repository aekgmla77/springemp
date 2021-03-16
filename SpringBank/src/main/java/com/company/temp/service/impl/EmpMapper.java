package com.company.temp.service.impl;

import java.util.List;
import java.util.Map;

import com.company.temp.service.SalesVO;

public interface EmpMapper {
	public List<Map<String, Object>> getEmpList();
	
	public List<Map<String, Object>> getSumList();
}

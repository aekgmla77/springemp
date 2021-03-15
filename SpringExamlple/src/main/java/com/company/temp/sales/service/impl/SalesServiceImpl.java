package com.company.temp.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.temp.sales.service.SalesService;
import com.company.temp.sales.service.SalesVO;

@Service
public class SalesServiceImpl implements SalesService{
	
	@Autowired SalesMapper mapper;

	@Override
	public int insertSale(SalesVO vo) {
		return mapper.insertSale(vo);
	}

}

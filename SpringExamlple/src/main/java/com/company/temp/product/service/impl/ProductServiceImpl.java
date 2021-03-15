package com.company.temp.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.temp.product.service.ProductService;
import com.company.temp.product.service.ProductVO;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired ProductMapper dao;
	
	@Override
	public List<ProductVO> getSearchProduct(ProductVO vo) {
		return dao.getSearchProduct(vo);
	}

	@Override
	public int insertProduct(ProductVO vo) {
		return dao.insertProduct(vo);
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		return dao.getProduct(vo);
	}

}

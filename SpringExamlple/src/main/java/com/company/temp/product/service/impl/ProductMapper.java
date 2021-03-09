package com.company.temp.product.service.impl;

import java.util.List;

import com.company.temp.product.service.ProductVO;

public interface ProductMapper {
	//조회
	public List<ProductVO> getSearchProduct(ProductVO vo);
	
	//등록
	public int insertProduct(ProductVO vo);
}

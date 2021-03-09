package com.company.temp.product.service;

import java.util.List;

public interface ProductService {
	//조회
	public List<ProductVO> getSearchProduct(ProductVO vo);
	
	//등록
	public int insertProduct(ProductVO vo);
	
}

package com.company.temp.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private String product_id;
	private String product_name;
	private String product_price;
	private String product_info;
	private String product_date; 
	private String company,manager_id;
}

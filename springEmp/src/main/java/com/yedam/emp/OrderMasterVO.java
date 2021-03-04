package com.yedam.emp;

import java.util.List;

import lombok.Data;

@Data
public class OrderMasterVO {
	private String name;
	private String addr;
	private String tel;
	List<OrderDetailVO> ords;
}

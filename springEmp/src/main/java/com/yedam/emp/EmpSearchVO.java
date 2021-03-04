package com.yedam.emp;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO{
	//페이징
	Integer page = 1;
	int start = 1;
	int end = 10;
}

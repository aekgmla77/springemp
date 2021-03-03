package com.yedam.emp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.emp.service.impl.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
	
	@Autowired EmpMapper empMapper;
	
	//@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empMapper.getEmp(vo);
//		assertEquals("100", resultVO.getEmployee_id());
		assertNotNull(resultVO);  // t/f
		System.out.println(resultVO);
	}
	
	//@Test
	public void getSearchEmp() {
		EmpVO vo = EmpVO.builder().first_name("na").build();
		List<EmpVO> list = empMapper.getSearchEmp(vo);
		System.out.println(list);
	}
	
	@Test
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()
						.first_name("fe")
						.last_name("tsef")
						.email("sevdcf")
						.hire_date(new java.sql.Date(new Date(0).getTime()))
						.job_id("IT_PROG")
						.department_id("50")
						.employee_id("668")
						.phone_number("010.2258.3334")
						.build();
		int result = empMapper.insertEmp(vo);
		assertEquals(result, 1);
	}
	
	//@Test
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()
						.email("sixss")
						.employee_id("666")
						.build();
		int result = empMapper.updateEmp(vo);
		assertEquals(result, 1);
	}

}

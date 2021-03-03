package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService{

//	@Autowired EmpSpringDAO empDAO;
//	@Autowired EmpMybatisDAO empDAO;
	@Autowired EmpMapper empDAO;
	
	@Override
	public int insertEmp(EmpVO vo) {
		return empDAO.insertEmp(vo);
	}

	@Override
	public int updateEmp(EmpVO vo) {
		return empDAO.updateEmp(vo);
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		return empDAO.deleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return empDAO.getEmp(vo);
	}

	@Override
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return empDAO.getSearchEmp(vo);
	}

}

package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired EmpSpringDAO empDAO;
	
	@Override
	public int insertEmp(EmpVO vo) {
		int n = 0;
		n = empDAO.insertEmp(vo);
		return n;
	}

	@Override
	public int updateEmp(EmpVO vo) {
		int n = 0;
		n = empDAO.updateEmp(vo);
		return n;
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		int n = 0;
		n = empDAO.deleteEmp(vo);
		return n;
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return null;
	}

	@Override
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return empDAO.getSearchEmp(vo);
	}

}

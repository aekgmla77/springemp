package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService{

//	@Autowired EmpSpringDAO empDAO;
//	@Autowired EmpMybatisDAO empDAO;
	@Autowired EmpMapper empDAO;
	
	@Transactional
	public int insertEmp(EmpVO vo) {
		return empDAO.insertEmp(vo);
	}

	public int updateEmp(EmpVO vo) {
		return empDAO.updateEmp(vo);
	}

	public int deleteEmp(EmpVO vo) {
		return empDAO.deleteEmp(vo);
	}

	public EmpVO getEmp(EmpVO vo) {
		return empDAO.getEmp(vo);
	}

	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		return empDAO.getSearchEmp(vo);
	}

	@Override
	public int getCount(EmpSearchVO vo) {
		return empDAO.getCount(vo);
	}

}

package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService{
	
//	@Autowired DeptDAO deptDAO;
	@Autowired DeptMapper deptDAO;
	
	@Override
	public int insertDept(DeptVO vo) {
		return deptDAO.insertDept(vo);
	}

	@Override
	public int updateDept(DeptVO vo) {
		return deptDAO.updateDept(vo);
	}

	@Override
	public int deleteDept(DeptVO vo) {
		return deptDAO.deleteDept(vo);
	}

	@Override
	public DeptVO getDept(DeptVO vo) {
		return deptDAO.getDept(vo);
	}

	@Override
	public List<DeptVO> getSearchDept(DeptVO vo) {
		return deptDAO.getSearchDept(vo);
	}

}

package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired JobMapper jobDAO;
	
	public int insertJob(JobVO vo) {
		return jobDAO.insertJob(vo);
	}

	public int updateJob(JobVO vo) {
		return jobDAO.updateJob(vo);
	}

	public int deleteJob(JobVO vo) {
		return jobDAO.deleteJob(vo);
	}

	public JobVO getJob(JobVO vo) {
		return jobDAO.getJob(vo);
	}

	public List<JobVO> getSearchJob(JobVO vo) {
		return jobDAO.getSearchJob(vo);
	}
	
}

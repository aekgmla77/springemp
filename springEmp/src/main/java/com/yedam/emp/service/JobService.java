package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.JobVO;

public interface JobService {
	//등록
	public int insertJob(JobVO vo);
	//수정
	public int updateJob(JobVO vo);
	//삭제
	public int deleteJob(JobVO vo);
	//단건조회
	public JobVO getJob(JobVO vo);
	//전체/검색 조회
	public List<JobVO> getSearchJob(JobVO vo);
}

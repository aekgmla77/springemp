package com.company.board.service;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardsVO {
	private String seq;
	private String title;
	private String writer;
	private String content;
	private String filename;
	// MultipartFile[] >> 여러건 올리려고 [] 배열로 변경
	private MultipartFile[] uploadFile;
}

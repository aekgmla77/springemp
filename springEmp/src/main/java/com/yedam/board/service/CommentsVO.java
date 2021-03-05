package com.yedam.board.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommentsVO {
	private String id;   //int(9자리), long(13자리)보다 더 큰 수 가능 BigDecimal   oracle-num > 38   
	private String name;
	private String content;
	private String board_id;
	private String out_msg;
	private String[] ids;  //List<ids>
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date wdate;
}

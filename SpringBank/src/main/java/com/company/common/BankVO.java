package com.company.common;

import lombok.Data;

@Data
public class BankVO {
	private String bank_tran_id;
	private String fintech_use_num;
	private String tran_dtime;
	private String access_token;
}

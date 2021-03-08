package com.yedam.emp;

import lombok.Data;

@Data
public class UsersVO {
	private String id;
	private String password;
	private String name;
	private String role;
	private String[] ids;
	private String oldpassword;
	private String newpass;
}

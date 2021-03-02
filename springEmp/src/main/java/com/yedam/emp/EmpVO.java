package com.yedam.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //이거 하나 하면 get, set, to string 등 다 나옴
@Builder                    //생성자 대체 가능
@NoArgsConstructor          //인수가 없는 빈 생성자
@AllArgsConstructor         //모든 생성자
public class EmpVO {
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private String salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
}

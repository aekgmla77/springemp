package com.yedam.emp;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //이거 하나 하면 get, set, to string 등 다 나옴
@Builder                    //생성자 대체 가능
@NoArgsConstructor          //인수가 없는 빈 생성자
@AllArgsConstructor         //모든 생성자
public class EmpVO {
	@NotEmpty(message = "last_name 입력하여 주세요.")
	private String employee_id;
	@NotEmpty(message = "first_name 입력하여 주세요.")
	private String first_name;
	@NotEmpty(message = "last_name 입력하여 주세요.")
	private String last_name;
	@NotEmpty(message = "email 입력하여 주세요.")
	private String email;
	@NotEmpty
	private String phone_number;
	@NotNull(message = "hire_date 필수입니다.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hire_date;
	@NotEmpty(message = "job_id 선택하여 주세요.")
	private String job_id;
	private String salary;
	private String commission_pct;
	@NotEmpty(message = "manager_id 입력하여 주세요.")
	private String manager_id;
	@NotEmpty(message = "department_id 선택하여 주세요.")
	private String department_id;
	private String department_name;
	private String job_title;
}

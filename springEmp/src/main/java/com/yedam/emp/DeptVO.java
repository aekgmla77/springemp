package com.yedam.emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@Builder                 
@NoArgsConstructor         
@AllArgsConstructor 
public class DeptVO {
	private String department_id;
	private String department_name;
	private String manager_id;
	private String location_id;
	private String city;
	private String last_name;
}

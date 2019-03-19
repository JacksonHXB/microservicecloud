package com.hxb.springcloud.entites;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String Introduce;
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")  //时间格式化
	private Date birth;

}


























package com.hxb.springcloud.entites;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*用户*/
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	private Integer id;//ID号			
	private String username;//名称
	private String password;
	private String gender;//性别
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")  //时间格式化
	private Date birth;//出生日期
	private String email;//Email地址
}











































































































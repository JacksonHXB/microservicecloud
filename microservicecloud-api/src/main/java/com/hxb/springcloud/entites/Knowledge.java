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
public class Knowledge {
	private Integer id;
	private String title;
	private String content;
	private String keyword;
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")  //时间格式化
	private Date time;
	private String websites;
}

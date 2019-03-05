package com.hxb.springcloud.entites;


import com.hxb.springcloud.utils.RespCode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class RespEntity {
	private int code;
	private String msg;
	private Object data;
	
	public RespEntity(RespCode respCode) {
		this.code = respCode.getCode();
		this.msg = respCode.getMsg();
	}	
	
	public RespEntity(RespCode respCode, Object data) {
		this(respCode);
		this.data = data;
		
	}
}
























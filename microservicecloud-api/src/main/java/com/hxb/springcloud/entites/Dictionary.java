package com.hxb.springcloud.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*字典类型表*/
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Dictionary {
	private Integer id;
	private String code;
	private String name;
}
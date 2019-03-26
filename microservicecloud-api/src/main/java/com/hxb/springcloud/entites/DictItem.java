package com.hxb.springcloud.entites;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*字典明细表*/
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DictItem {
	private Integer id;
	private Integer dict_id;
	private String name;
	private String value;
	private Date update_time;
}















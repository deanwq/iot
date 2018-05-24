package com.entity;

import com.alibaba.fastjson.JSON;

public abstract class DSObj {
	public String toJson() {
		return JSON.toJSONString(this);
	}
}

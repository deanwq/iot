package com.entity;

public class Resp {
	
	public int ret;
	public String msg;
	public Object body;
	
	public int getRet() {
		return ret;
	}
	public void setRet(int ret) {
		this.ret = ret;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public Resp(int ret, String msg, Object body) {
		super();
		this.ret = ret;
		this.msg = msg;
		this.body = body;
	}
	
	
}

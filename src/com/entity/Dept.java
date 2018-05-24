package com.entity;

public class Dept extends DSObj{
	private int id;
	private int pid;
	private String name;
	private int corp_id;//客户ID
	private String ctime;
	private String utime;
	
	@Override
	public String toString() {
		return this.toJson();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCorp_id() {
		return corp_id;
	}
	public void setCorp_id(int corp_id) {
		this.corp_id = corp_id;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getUtime() {
		return utime;
	}

	public void setUtime(String utime) {
		this.utime = utime;
	}
	
	
}

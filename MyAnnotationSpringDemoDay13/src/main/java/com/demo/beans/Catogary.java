package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Catogary {
	@Value("1")
	private int pid;
	@Value("Fruits")
	private String cname;
	public Catogary() {
		super();
	}
	public Catogary(int pid, String cname) {
		super();
		this.pid = pid;
		this.cname = cname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Catogary [pid=" + pid + ", cname=" + cname + "]";
	}
	

}

package com.demo.beans;

public class MyUser implements   {
	
	private int uid;
	private String uname;
	
	public MyUser() {
		super();
		System.out.println("in default constructore");
	}

	public MyUser(int uid, String uname) {
		super();
		System.out.println("int parametrize constructore");
		this.uid = uid;
		this.uname = uname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		System.out.println("in myuser setUid");
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		System.out.println("in myuser setUname");
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + "]";
	}
	
	public void setBeanName(String name) {
		System.out.println("in setBeanNmae"+name);
	}
	public void 
	
	

}

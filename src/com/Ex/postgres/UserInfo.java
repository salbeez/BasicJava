package com.Ex.postgres;

public class UserInfo {// DB?��?��블의 ?��코드 ?���?(?�� ?��?��)�? ?��바객체로 ?��?��
	private String id;
	private String name;
	private String hiredate;
	private String sal;
	private String dname;

	public UserInfo() {
	}

	public UserInfo(String id, String name, String hiredate, String sal, String dname) {
		super();
		this.id = id;
		this.name = name;
		this.hiredate = hiredate;
		this.sal = sal;
		this.dname = dname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

}

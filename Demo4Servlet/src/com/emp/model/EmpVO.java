package com.emp.model;

public class EmpVO {
	private String name;
	private int age;
	private int sal;
	private String id;
	private String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public String getJob(){
		return this.job;
	}
	public void setJob(String job){
		this.job = job;
	}
	
}

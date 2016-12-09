package com.xf.page.model;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9049720389372212721L;

	private int id;
	
	private String name;
	
	private int age;
	
	private int gender;
	
	private String address;

	public int getId() {
		return id;
	}
	
	

	public Student() {
		super();
	}

	public Student(Map<String, Object> map){
		this.id = (Integer)map.get("id");
		this.name = (String)map.get("stu_name");
		this.age = (Integer)map.get("age");
		this.gender = (Integer)map.get("gender");
		this.address = (String)map.get("address");
	}


	public Student(int id, String name, int age, int gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}



	public void setId(int id) {
		this.id = id;
	}

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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
	
}

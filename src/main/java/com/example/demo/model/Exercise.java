package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exercise")
public class Exercise {
	
	@Id
	 private int id;
	
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
private	String uname;
	private String exname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getExname() {
		return exname;
	}
	public void setExname(String exname) {
		this.exname = exname;
	}

}

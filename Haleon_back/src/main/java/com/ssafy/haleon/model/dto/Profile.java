package com.ssafy.haleon.model.dto;

public class Profile {
	private String userName;
	private int period;
	private int height;
	private int bmi;
	private int weight;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getBmi() {
		return bmi;
	}
	public void setBmi(int bmi) {
		this.bmi = bmi;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}

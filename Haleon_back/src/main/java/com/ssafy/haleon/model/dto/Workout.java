package com.ssafy.haleon.model.dto;

public class Workout {
	private String regDate;
	private String id;
	private String cal;
	private String burn;
	private String workTime;
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCal() {
		return cal;
	}
	public void setCal(String cal) {
		this.cal = cal;
	}
	public String getBurn() {
		return burn;
	}
	public void setBurn(String burn) {
		this.burn = burn;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	@Override
	public String toString() {
		return "Workout [regDate=" + regDate + ", id=" + id + ", cal=" + cal + ", burn=" + burn + ", workTime="
				+ workTime + "]";
	}
	
	
}

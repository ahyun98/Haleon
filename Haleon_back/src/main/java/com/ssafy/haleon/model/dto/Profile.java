package com.ssafy.haleon.model.dto;

public class Profile {
	private String id;
	private int period;
	private int height;
	private int bmi;
	private int weight;
	private int fatRate;
	private int muscleRate;
	
	
	@Override
	public String toString() {
		return "Profile [id=" + id + ", period=" + period + ", height=" + height + ", bmi=" + bmi + ", weight=" + weight
				+ ", fatRate=" + fatRate + ", muscleRate=" + muscleRate + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFatRate() {
		return fatRate;
	}
	public void setFatRate(int fatRate) {
		this.fatRate = fatRate;
	}
	public int getMuscleRate() {
		return muscleRate;
	}
	public void setMuscleRate(int muscleRate) {
		this.muscleRate = muscleRate;
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

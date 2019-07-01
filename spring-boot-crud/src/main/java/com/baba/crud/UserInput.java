package com.baba.crud;

public class UserInput {
	
	public UserInput(double startingSal, int incrementPercent, int incrementFreq, int deductionPercent, int deductionFreq, int yrsOfPrediction) {
		super();
		this.startingSal = startingSal;
		this.incrementPercent = incrementPercent;
		this.incrementFreq = incrementFreq;
		this.deductionPercent = deductionPercent;
		this.deductionFreq = deductionFreq;
		this.yrsOfPrediction = yrsOfPrediction;
	}

	private double startingSal;
	private int incrementPercent;
	private int incrementFreq;
	private int deductionPercent;
	private int deductionFreq;
	private int yrsOfPrediction;
	
	public double getStartingSal() {
		return startingSal;
	}
	public void setStartingSal(double startingSal) {
		this.startingSal = startingSal;
	}
	public int getIncrementPercent() {
		return incrementPercent;
	}
	public void setIncrementPercent(int incrementPercent) {
		this.incrementPercent = incrementPercent;
	}
	public int getIncrementFreq() {
		return incrementFreq;
	}
	public void setIncrementFreq(int incrementFreq) {
		this.incrementFreq = incrementFreq;
	}
	public int getDeductionPercent() {
		return deductionPercent;
	}
	public void setDeductionPercent(int deductionPercent) {
		this.deductionPercent = deductionPercent;
	}
	public int getDeductionFreq() {
		return deductionFreq;
	}
	public void setDeductionFreq(int deductionFreq) {
		this.deductionFreq = deductionFreq;
	}
	public int getYrsOfPrediction() {
		return yrsOfPrediction;
	}
	public void setYrsOfPrediction(int yrsOfPrediction) {
		this.yrsOfPrediction = yrsOfPrediction;
	}
	
	@Override
	public String toString() {
		return "UserInput [startingSal=" + startingSal + ", incrementPercent=" + incrementPercent + ", incrementFreq="
				+ incrementFreq + ", deductionPercent=" + deductionPercent + ", deductionFreq=" + deductionFreq
				+ ", yrsOfPrediction=" + yrsOfPrediction + "]";
	}
	
	
}

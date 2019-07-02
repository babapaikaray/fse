package com.baba.crud.model;

public class SPInputParams {
	
	String startSal = "";
	String incrementPer = "";
	String freqOfIncrement = "";
	String deductionPer = "";
	String freqOfDeductions = "";
	String predictionForYrs = "";
	
	public String getDeductionPer() {
		return deductionPer;
	}
	public void setDeductionPer(String deductionPer) {
		this.deductionPer = deductionPer;
	}
	public String getStartSal() {
		return startSal;
	}
	public void setStartSal(String startSal) {
		this.startSal = startSal;
	}
	public String getIncrementPer() {
		return incrementPer;
	}
	public void setIncrementPer(String incrementPer) {
		this.incrementPer = incrementPer;
	}
	public String getFreqOfIncrement() {
		return freqOfIncrement;
	}
	public void setFreqOfIncrement(String freqOfIncrement) {
		this.freqOfIncrement = freqOfIncrement;
	}
	
	public String getFreqOfDeductions() {
		return freqOfDeductions;
	}
	public void setFreqOfDeductions(String freqOfDeductions) {
		this.freqOfDeductions = freqOfDeductions;
	}
	public String getPredictionForYrs() {
		return predictionForYrs;
	}
	public void setPredictionForYrs(String predictionForYrs) {
		this.predictionForYrs = predictionForYrs;
	}
	@Override
	public String toString() {
		return "SPInputParams [startSal=" + startSal + ", incrementPer=" + incrementPer + ", freqOfIncrement="
				+ freqOfIncrement + ", deductions=" + deductionPer + ", freqOfDeductions=" + freqOfDeductions
				+ ", predictionForYrs=" + predictionForYrs + "]";
	}
	
	

}

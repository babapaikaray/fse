package com.baba.crud;

public class UserReport {
	
	private int year;
	private double startingSal;
	private int noOfIncrements;
	private int incrementPercentage;
	private double incrementAmount;
	private int noOfDeductions;
	private int deductionPercentage;
	private double deductionAmount;
	private double salaryGrowth;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getStartingSal() {
		return startingSal;
	}
	public void setStartingSal(double startingSal) {
		this.startingSal = startingSal;
	}
	public int getNoOfIncrements() {
		return noOfIncrements;
	}
	public void setNoOfIncrements(int noOfIncrements) {
		this.noOfIncrements = noOfIncrements;
	}
	public int getIncrementPercentage() {
		return incrementPercentage;
	}
	public void setIncrementPercentage(int incrementPercentage) {
		this.incrementPercentage = incrementPercentage;
	}
	public double getIncrementAmount() {
		return incrementAmount;
	}
	public void setIncrementAmount(double incrementAmount) {
		this.incrementAmount = incrementAmount;
	}
	public int getNoOfDeductions() {
		return noOfDeductions;
	}
	public void setNoOfDeductions(int noOfDeductions) {
		this.noOfDeductions = noOfDeductions;
	}
	public int getDeductionPercentage() {
		return deductionPercentage;
	}
	public void setDeductionPercentage(int deductionPercentage) {
		this.deductionPercentage = deductionPercentage;
	}
	public double getDeductionAmount() {
		return deductionAmount;
	}
	public void setDeductionAmount(double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}
	public double getSalaryGrowth() {
		return salaryGrowth;
	}
	public void setSalaryGrowth(double salaryGrowth) {
		this.salaryGrowth = salaryGrowth;
	}
	
	@Override
	public String toString() {
		return "UserReport [year=" + year + ", startingSal=" + startingSal + ", noOfIncrements=" + noOfIncrements
				+ ", incrementPercentage=" + incrementPercentage + ", incrementAmount=" + incrementAmount
				+ ", noOfDeductions=" + noOfDeductions + ", deductionPercentage=" + deductionPercentage
				+ ", deductionAmount=" + deductionAmount + ", salaryGrowth=" + salaryGrowth + "]";
	}
	
}

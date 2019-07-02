package com.baba.crud.model;

public class IncrementReport {
 Float startingSal;
 String noOfIncrements;
 Float incrementPer;
 Float incrementAmt;
 
public Float getStartingSal() {
	return startingSal;
}
public void setStartingSal(Float startingSal) {
	this.startingSal = startingSal;
}
public String getNoOfIncrements() {
	return noOfIncrements;
}
public void setNoOfIncrements(String noOfIncrements) {
	this.noOfIncrements = noOfIncrements;
}
public Float getIncrementPer() {
	return incrementPer;
}
public void setIncrementPer(Float incrementPer) {
	this.incrementPer = incrementPer;
}
public Float getIncrementAmt() {
	return incrementAmt;
}
public void setIncrementAmt(Float incrementAmt) {
	this.incrementAmt = incrementAmt;
}
@Override
public String toString() {
	return "IncrementReport [startingSal=" + startingSal + ", noOfIncrements=" + noOfIncrements + ", incrementPer="
			+ incrementPer + ", incrementAmt=" + incrementAmt + "]";
}


 
}

package com.baba.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baba.crud.model.Constants;
import com.baba.crud.model.DeductionReport;
import com.baba.crud.model.IncrementReport;
import com.baba.crud.model.PredictionReport;
import com.baba.crud.model.SPInputParams;

public class SalaryIncomePredictor {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		SPInputParams ip = new SPInputParams();
	    //  prompt for the user's name
	    System.out.print("Starting salary: ");
	    ip.setStartSal(scanner.next());
	    
	    System.out.print("Increment to be received in percent: ");	    
	    ip.setIncrementPer(scanner.next());
	    
	    System.out.print("How frequently increment received: ");	    
	    ip.setFreqOfIncrement(scanner.next());
	    
	    System.out.print("Deductions on income in percent: ");	    
	    ip.setDeductionPer(scanner.next());	    
	    
	    System.out.print("How frequently deductions done: ");	    
	    ip.setFreqOfDeductions(scanner.next());
	    
	    System.out.print("Predictions for (years): ");
	    ip.setPredictionForYrs(scanner.next());
	    
	    if(!validateInput(ip).isEmpty()) {
	    	List<String> err= validateInput(ip);
	    	for(String msg : err) {
	    		System.out.println(msg);
	    	}
	    	scanner.close();
	    	return;
	    }
	    List<IncrementReport> incrementRepot = prepareIncrementReport(ip);  
	    preparePredictionReport(incrementRepot, prepareDeductionReport(ip,incrementRepot));
	    scanner.close();
	}
	
	public static List<String> validateInput(SPInputParams ip) {
		List<String> errorMsg = new ArrayList<String>();
		if(null != ip.getStartSal()
	    		&& new Float(ip.getStartSal()) < 1.0F) {
			errorMsg.add("Starting salary cannot be less than 1");
	    }
		if(null != ip.getIncrementPer()
	    		&& new Float(ip.getIncrementPer()) < 0.0F) {
			errorMsg.add("Increment percent cannot be less than 0");
	    }
		if(null != ip.getDeductionPer()
	    		&& new Float(ip.getDeductionPer()) < 0.0F) {
			errorMsg.add("Decrement percent cannot be less than 0");
	    }
		return errorMsg;
	}
	
	public static List<IncrementReport>  prepareIncrementReport(SPInputParams ip) {		
		
		Float startSal = new Float(ip.getStartSal());
		Float incrementPer = new Float(ip.getIncrementPer())/100;
		int predictionYrs = Integer.parseInt(ip.getPredictionForYrs());
		int freqOfIncr = 0;
		Float incrementAmt = 0.0F;
		List<IncrementReport> lst = new ArrayList<>();		
		
		if(ip.getFreqOfIncrement().equalsIgnoreCase("QUARTERLY")) {
			freqOfIncr = Constants.QUARTERLY;			
		}else if(ip.getFreqOfIncrement().equalsIgnoreCase("HALF-YEARLY")) {
			freqOfIncr = Constants.HALF_YEARLY;
		}else if(ip.getFreqOfIncrement().equalsIgnoreCase("YEARLY")) {
			freqOfIncr = Constants.YEARLY;
		}else if(ip.getFreqOfIncrement().equalsIgnoreCase("MONTHLY")) {
			freqOfIncr = Constants.MONTHLY;
		}
		System.out.println("\n\n--Increment Report----");
		System.out.println("Year  Starting Salary  No.ofIncrements  % Of Increment  Increment Amount");
		for(int i =1; i <= predictionYrs; i++) { 
			IncrementReport ir = new IncrementReport();
			incrementAmt = 0.0F;
			for(int j=0;j < freqOfIncr;j++ ) {				
				incrementAmt = incrementAmt+(startSal*incrementPer);
			}
			ir.setStartingSal(startSal);
			startSal = startSal +incrementAmt;
			ir.setIncrementPer(incrementPer);
			ir.setIncrementAmt(incrementAmt);
			ir.setNoOfIncrements(String.valueOf(freqOfIncr));
			lst.add(ir);
			System.out.println(i+"	"+ir.getStartingSal()+"		 "+ir.getNoOfIncrements()+"		 "+ir.getIncrementPer()+" 		"+ir.getIncrementAmt());
		}		
		return lst;		
	}
	

public static List<DeductionReport>  prepareDeductionReport(SPInputParams ip,List<IncrementReport> ir) {		
		
		
		Float deductionPer = new Float(ip.getDeductionPer())/100;
		int predictionYrs = Integer.parseInt(ip.getPredictionForYrs());
		int freqOfDeduction = 0;
		Float deductionAmt = 0.0F;
		List<DeductionReport> lst = new ArrayList<>();		
		
		if(ip.getFreqOfIncrement().equalsIgnoreCase("QUARTERLY")) {
			freqOfDeduction = Constants.QUARTERLY;			
		}else if(ip.getFreqOfIncrement().equalsIgnoreCase("HALF-YEARLY")) {
			freqOfDeduction = Constants.HALF_YEARLY;
		}else if(ip.getFreqOfIncrement().equalsIgnoreCase("YEARLY")) {
			freqOfDeduction = Constants.YEARLY;
		}else if(ip.getFreqOfIncrement().equalsIgnoreCase("MONTHLY")) {
			freqOfDeduction = Constants.MONTHLY;
		}
		System.out.println("\n\n--Deduction Report----");
		System.out.println("Year  Starting Salary  No.ofDeductions  % Of Deduction  Deduction Amount");
		for(int i =1; i <= predictionYrs; i++) { 
			DeductionReport dr = new DeductionReport();
			deductionAmt = 0.0F;
			for(int j=0;j < freqOfDeduction;j++ ) {				
				deductionAmt = deductionAmt+(ir.get(i-1).getStartingSal()*deductionPer);
			}
			dr.setStartingSal(ir.get(i-1).getStartingSal());			
			dr.setDeductionPer(deductionPer);
			dr.setDeductionAmt(deductionAmt);
			dr.setNoOfDeductions(String.valueOf(freqOfDeduction));
			lst.add(dr);
			System.out.println(i+"	"+dr.getStartingSal()+"		 "+dr.getNoOfDeductions()+"		 "+dr.getDeductionPer()+" 		"+dr.getDeductionAmt());
		}		
		return lst;		
	}

public static List<PredictionReport>  preparePredictionReport(List<IncrementReport> ir, List<DeductionReport> dr) {		
	
	
	List<PredictionReport> lst = new ArrayList<>();		
	
	
	System.out.println("\n\n--Prediction Report----");
	System.out.println("Year  Starting Salary  Increment Amount  Deduction Amount  Growth");
	int i = 1;
	
	for(IncrementReport irR: ir ) {		
		DeductionReport drObj = dr.get(i-1);
		PredictionReport pr = new PredictionReport();
		pr.setDeductiontAmt(drObj.getDeductionAmt());
		pr.setIncrementAmt(irR.getIncrementAmt());
		pr.setGrowthPer((((irR.getStartingSal()+(irR.getIncrementAmt() - drObj.getDeductionAmt()))/irR.getStartingSal())*100)-100);
		pr.setStartingSal(irR.getStartingSal());
		
		System.out.println(i+"	"+pr.getStartingSal()+"		 "+pr.getIncrementAmt()+"		 "+pr.getDeductiontAmt()+" 		"+pr.getGrowthPer());
		i++;
	}		
	return lst;		
}
}

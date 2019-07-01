package com.baba.crud;

import java.util.Scanner;

public class SalaryIncomePredictor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		double startingSal;
		int incrementPercent;
		int incrementFreq;
		int deductionPercent;
		int deductionFreq;
		int yrsOfPrediction;
		
		System.out.println("Welcome to Salary Income Predictor");
		
		System.out.println("What is the starting salary?");
		startingSal = input.nextDouble();
		
		System.out.println("Increment to be received in percent:");
		incrementPercent = input.nextInt();
		
		System.out.println("How frequently is increment received \nEnter 4 for quarterly \nEnter 2 for half-yearly \nEnter 1 for annually etc.");
		incrementFreq = input.nextInt();
		
		System.out.println("Enter Deductions on income");
		deductionPercent = input.nextInt();
		
		System.out.println("How frequently aredeductions done \nEnter 4 for quarterly \nEnter 2 for half-yearly \nEnter 1 for annually etc.");
		deductionFreq = input.nextInt();
		
		System.out.println("Enter the number of Years for Prediction");
		yrsOfPrediction = input.nextInt();
		
		UserInput userInput = new UserInput(startingSal, incrementPercent, incrementFreq, deductionPercent, deductionFreq, yrsOfPrediction);

	}

}

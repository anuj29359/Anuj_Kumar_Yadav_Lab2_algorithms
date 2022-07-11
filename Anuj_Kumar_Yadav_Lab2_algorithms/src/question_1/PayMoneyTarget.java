package question_1;

import java.util.Iterator;
import java.util.Scanner;

public class PayMoneyTarget {
	private int[] transactions;
	private int targetValue;
	private int targetCount;
	

	public int[] getTransactions() {
		return transactions;
	}



	public void setTransactions(int[] transactions) {
		this.transactions = transactions;
	}



	public int getTargetValue() {
		return targetValue;
	}



	public int getTargetCount() {
		return targetCount;
	}



	public void setTargetCount(int targetCount) {
		this.targetCount = targetCount;
	}



	public void setTargetValue(int target) {
		this.targetValue = target;
	}
	
	public void enterTransactions(int size) {
		int[] txns = new int[size];
		Scanner scn = new Scanner(System.in);
		for (int i = 0; i < txns.length; i++) {
			txns[i] = scn.nextInt();
//			for (int j = 0; j < txns.length; j++) {
//				System.out.print(" "+ txns[j]);
//			}
		}
		this.setTransactions(txns);
		
	}


	private void getTargetAchievementIndx() {
		int sum = 0;
		int j = 0;
		for (int i : this.transactions) {
			if(this.targetValue > sum) {
				sum += i;
				j++;
			}
			else break;
		}
		
		if(this.targetValue > sum || this.targetCount > this.transactions.length) {
			System.out.println("Given target is not achieved");
		}
		else {
			System.out.println("Target achieved after " + j + " transactions");
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		int[] txns;
		int tgt;
		
		PayMoneyTarget pmt = new PayMoneyTarget();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of transaction array ");
		size = sc.nextInt();
		System.out.println("Enter the values of array");
		pmt.enterTransactions(size);
		System.out.println("Enter the total no of targets that needs to be achieved");
		tgt = sc.nextInt();
		
		pmt.setTargetCount(tgt);
		System.out.println("Enter the value of target");
		pmt.setTargetValue(sc.nextInt());
		pmt.getTargetAchievementIndx();
		
	}




}

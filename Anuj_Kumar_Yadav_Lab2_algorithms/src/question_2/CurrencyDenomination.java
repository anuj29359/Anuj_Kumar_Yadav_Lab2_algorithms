package question_2;

import java.util.Scanner;

public class CurrencyDenomination {
	private int[] denominations;
	
	public void setDenominations(int size) {
		this.denominations = new int[size];
		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < size; i++) {
			Scanner sc = new Scanner(System.in);
			
			this.denominations[i] = sc.nextInt();
			
		}
		MergeSort ms = new MergeSort();
		ms.mergeSortArray(this.denominations, 0 , this.denominations.length -1);
	}
	
	public int[] getDenominations() {
		return this.denominations;
	}
	
	public void getPaymentApproach(int amt) {
		/**
		 * method to find the minimum number of denomination-note to match the total amount 
		 */
		
		int[] selectedDenominations = new int[this.denominations.length];
		for (int i = 0; i < selectedDenominations.length; i++) {
			selectedDenominations[i] = this.denominations[i];
		}
		int[] selectedDenominationsCnt = new int[this.denominations.length];
		
		if(amt <=0) {
			System.out.println("invalid input");
		}
		else {
			int i = 0;
			int len = this.denominations.length;
			int hn = this.denominations[--len];
			while(amt >= this.denominations[0]) { //this.denomination has been sorted in asc order using MergeSort
				if(amt >= hn) {
					for (int j = 0; j < selectedDenominations.length; j++) {
						if(selectedDenominations[j]==hn) {
							selectedDenominationsCnt[j]++;
						}	
					}
					amt = amt - hn;
					if(amt == 0) {
						break;
					}
				}
				else if(hn > amt) {
					if(len == 0) {
						break;
					}
					else
					hn = this.denominations[--len];
				}

			}
			for (int j = selectedDenominationsCnt.length-1;j>=0; j--) {
				if(selectedDenominationsCnt[j] != 0) {
					System.out.println(selectedDenominations[j] + ": " + selectedDenominationsCnt[j]);
				}
				
				
			}
			if(amt != 0) {
				System.out.println("remaining amount that didnt find a right denomination: " + amt);
			}
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Enter the size of currency denominations");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		// create CurrencyDenomination object
		CurrencyDenomination cd = new CurrencyDenomination();
		cd.setDenominations(size);
		// take the input of for the amount to pay
		System.out.println("Enter the amount you want to pay");
		int amt = sc.nextInt();
		
		//logic to find the minimum number of denominations for the given amount
		cd.getPaymentApproach(amt);
	}

}

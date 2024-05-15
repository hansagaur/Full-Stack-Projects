package com.gl.javafsd.paymoney;

import java.util.Arrays;

public class TargetDeterminator {
	
	private int[] transactions;
	private int dailytarget;
	
	private boolean outcome;
	
	public TargetDeterminator(int[] transactions, int dailytarget) {
		this.transactions = transactions;
		this.dailytarget = dailytarget;
	}


	public int[] getTransactions() {
		return transactions;
	}

	public void setTransactions(int[] transactions) {
		this.transactions = transactions;
	}

	public int getDailytarget() {
		return dailytarget;
	}

	public void setDailytarget(int dailytarget) {
		this.dailytarget = dailytarget;
	}

	public boolean isOutcome() {
		return outcome;
	}

	public void setOutcome(boolean outcome) {
		this.outcome = outcome;
	}
	
	
	void determine()
	{
		int tempSum = 0;
		int transactionCounter = 0;
		
		for (int index = 0; index < transactions.length; index ++)
		{
			int transactionValue = transactions[index];
			
			tempSum = tempSum + transactionValue;
			
			if (tempSum >= dailytarget)
			{
				outcome = true;
				transactionCounter = index + 1;
				break;
			}
		}
		
		if (outcome) {
            System.out.println(
                String.format(
            "Daily target of %d is achieved after %d transactions - from the transactions list [%s]",
                dailytarget, transactionCounter, Arrays.toString(transactions)));
        }else {
            System.out.println(
                String.format(
                "Daily target of %d CANNOT BE Achieved - from the transactions list [%s]",
                dailytarget, Arrays.toString(transactions)));
        }

		}
	}



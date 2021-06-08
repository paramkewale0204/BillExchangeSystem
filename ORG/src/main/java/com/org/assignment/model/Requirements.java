package com.org.assignment.model;

public class Requirements {
	
    private int amount;
    private int limit1;
    private int limit2;
    private int limit3;
    private int limit4;
    
    public Requirements() {}

    public Requirements(int amount, int limit1,int limit2,int limit3,int limit4) {
    	this.amount = amount;
    	this.limit1 = limit1;
    	this.limit2 = limit2;
    	this.limit3 = limit3;
    	this.limit4 = limit4;
    }

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLimit1() {
		return limit1;
	}

	public void setLimit1(int limit1) {
		this.limit1 = limit1;
	}

	public int getLimit2() {
		return limit2;
	}

	public void setLimit2(int limit2) {
		this.limit2 = limit2;
	}

	public int getLimit3() {
		return limit3;
	}

	public void setLimit3(int limit3) {
		this.limit3 = limit3;
	}

	public int getLimit4() {
		return limit4;
	}

	public void setLimit4(int limit4) {
		this.limit4 = limit4;
	}
    
    
}

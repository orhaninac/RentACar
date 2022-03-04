package com.orhaninac.RentACar.core.utilities.results;


public class SuccesResult extends Result{

	public SuccesResult(boolean success) {
		super(true);
	}
	
	public SuccesResult(String message) {
		super(true,message);
	}

}

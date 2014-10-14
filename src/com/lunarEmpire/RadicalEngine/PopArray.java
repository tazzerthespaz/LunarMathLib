package com.lunarEmpire.RadicalEngine;

import java.util.Arrays;

//This class is responsible for setting up the prime list array and the prime tally array
//takes in array details and outputs the final array
// houses the Array.length() and the array.fill methods for cleaner code
public class PopArray {
	private int[] workingArray;
	
	PopArray(int numItems, int itemFill){
		this.workingArray = new int[numItems];
		Arrays.fill(workingArray, itemFill);
		
	}
	public int[] getWorkingArray(){
		return this.workingArray;
	}
}

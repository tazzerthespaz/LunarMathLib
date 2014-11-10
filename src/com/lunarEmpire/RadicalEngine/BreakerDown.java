package com.lunarEmpire.RadicalEngine;

import java.util.HashMap;

public class BreakerDown {
	private int input;
	private Map<Integer,Integer> dictionary = new PrimeDict(input).getDict();
	
	BreakerDown(int input){
		this.input = input;
		
		//The loop that actually does the breakdown
		for()
	}
	
	private boolean canFactor(int number, int potFactor){
		if(number % potFactor == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public Map<Integer,Integer> getDictionary(){
		return this.dictionary;
	}
}

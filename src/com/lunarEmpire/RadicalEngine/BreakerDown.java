package com.lunarEmpire.RadicalEngine;

import java.math.BigInteger;
import java.util.Map;

public class BreakerDown {
	private int input;
	private Map<Integer,Integer> dictionary = new PrimeDict(input).getDict();
	
	BreakerDown(int input){
		this.input = input;
		
		int runningNum = input;
		//The loop that actually does the breakdown
		for(int key : dictionary.keySet()){
			//can you factor out the key from the running number?
			if(canFactor(runningNum,key)){
				//yes, add a tally to the HashMap per the respective key
				runningNum = runningNum / key;
				
			}else{
				//you can't factor it out, just keep going
				continue;
			}
		}
	}
	
	private boolean canFactor(int number, int potFactor){
		if(number % potFactor == 0){
			return true;
		}else{
			return false;
		}
	}
	private boolean isPrime(int number){
		boolean isPrime = (new BigInteger(Integer.toString(number))).isProbablePrime(32);
		return isPrime;
		
	}
	
	public Map<Integer,Integer> getDictionary(){
		return this.dictionary;
	}
}

package com.lunarEmpire.RadicalEngine;

import java.math.BigInteger;
import java.util.Map;


public class Radical{
	private int inNum;
	private int outNum;
	private int index;
	private int simpInNum;
	private int simpOutNum;
	private boolean imaginary;
	private Map<Integer, Integer> dictionary;
	
	Radical(int inNum, int outNum, int index){
		this.inNum = inNum;
		this.outNum = outNum;
		this.index = index;
		this.dictionary = new BreakerDown(inNum).getDictionary();
		simplify();
	}
	
	private void simplify(){
		//now to "pull" out pairs of numbers
		//first have to iterate through the keys and their pairs
		this.simpOutNum = this.outNum;
		this.simpInNum = this.inNum;
		for(int key : dictionary.keySet() ){
			
			if(dictionary.get(key) >= index ){ // If there is enough to take out a set
				simpOutNum = simpOutNum * ((int)(dictionary.get(key) / index) * key); // the outer number is multiplied by the taken out values
				dictionary.put(key, (int)(dictionary.get(key) / index)); // the left over numbers that weren't taken out are left in the map

			}
		}
	}
	public int getSimpInNum(){
		return this.simpInNum;
	}
	public int getSimpOutNum(){
		return this.simpOutNum;
	}
	
}
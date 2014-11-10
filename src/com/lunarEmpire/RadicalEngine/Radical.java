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
		this.simpInNum = 1;
		for(int key : dictionary.keySet() ){
			
			if(dictionary.get(key) >= index ){ // If there is enough to take out a set
				simpOutNum = (int) (simpOutNum * (Math.pow(key,(int)(dictionary.get(key) / index)))); // the outer number is multiplied by the taken out values
				System.out.println("The value for the key: " + key + " is: " + dictionary.get(key));
				dictionary.put(key,dictionary.get(key) - (int)(dictionary.get(key) / index) * index); // the left over numbers that weren't taken out are left in the map
			}
			
		}
		for(int key : dictionary.keySet() ) {
			System.out.println("The later value for the key: " + key + " is: " + dictionary.get(key));
			this.simpInNum *= (Math.pow(key, dictionary.get(key)));
		}
	}
	public int getSimpInNum(){
		return this.simpInNum;
	}
	public int getSimpOutNum(){
		return this.simpOutNum;
	}
	
}
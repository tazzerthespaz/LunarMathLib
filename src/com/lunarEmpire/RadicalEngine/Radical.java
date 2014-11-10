package com.lunarEmpire.RadicalEngine;

import java.math.BigInteger;
import java.util.Map;


public class Radical{
	private int inNum;
	private int outNum;
	private int simpInNum;
	private int simpOutNum;
	private boolean imaginary;
	private Map<Integer, Integer> dictionary = new BreakerDown(inNum).getDictionary();
	
	Radical(int inNum, int outNum){
		this.inNum = inNum;
		this.outNum = outNum;
	}
}
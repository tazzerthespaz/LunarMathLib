package com.lunarEmpire.RadicalEngine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigInteger;

//import java.util.Scanner;

public class EngineTester {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		for(int i = 0;i <= 25; i++){
			boolean isPrime = new BigInteger(Integer.toString(i)).isProbablePrime(32);
			System.out.println(i + " : " + isPrime);
		}
		boolean isPrime = new BigInteger(Integer.toString(556)).isProbablePrime(32);
		System.out.println(isPrime);
	}

}
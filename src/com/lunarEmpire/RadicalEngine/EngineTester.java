package com.lunarEmpire.RadicalEngine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

//import java.util.Scanner;

public class EngineTester {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Radical testRad = new Radical(556,1,2);
		testRad.simplify();
		System.out.println(testRad.cur_out_num + "sqrt(" + testRad.cur_in_num + ")");
	}

}
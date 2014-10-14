package com.lunarEmpire.RadicalEngine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

//import java.util.Scanner;

public class EngineTester {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Input an inner Value: ");
//		int innerVal = keyboard.nextInt();
//		System.out.println("Input an index: ");
//		int index = keyboard.nextInt();
//		keyboard.close();
		
		//PrintWriter writer = new PrintWriter("autoTable.txt", "UTF-8");
		//writer.println("Input Value      OuterNumber      InnerNumber");
		//for(int innerVal = 0;innerVal <= 10000;innerVal++){
			Radical testRad = new Radical(556,1,2);
			testRad.simplify();
			//writer.println(innerVal + "      " + testRad.cur_out_num + "      " + testRad.cur_in_num);
		//}
		//writer.close();
		System.out.println(Array.getLength(testRad.prime_list));
//		System.out.println(testRad.cur_out_num + "sqrt(" + testRad.cur_in_num + ")");
	}

}

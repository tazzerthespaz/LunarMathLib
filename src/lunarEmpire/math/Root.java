package lunarEmpire.math;

import lunarEmpire.math.Radical;

public class Root {
/*
 * uses:    e (+/-) √(f)
 * 		   --------------
 * 				 g
 */
	private int e;
	private int f;
	private int g;
	
	private boolean imaginary;
	private Fraction outerNumber; //The number outside
	private Fraction offset; //The e number
	private int innerNumber; // The f number
	
	//The decimal values for the roots
	private double decPosRoot;
	private double decNegRoot;
	
	Root(int e, int f, int g) {
		setE(e);
		setF(f);
		setG(g);
		
		compute();
	}
	

	public String toString(boolean positive) { //Need unit test
		String ending;
		if(this.innerNumber == 1) {
			ending = "";
		}else {
			ending = "√(" + this.innerNumber + ")";
		}
		
		char negOrPos;
		if(positive) {
			negOrPos = '+';
		} else {
			negOrPos = '-';
		}
		
		String rootString = offset.toString() + negOrPos + outerNumber.toString() + ending;
		return rootString;
	}
	
	private void compute() { //Need a unit test
		//the main meat of the class which is just the filler to keep things out of the constructor
		Radical rad = new Radical(this.f,1,2);
		
		setImaginary(rad.isImaginary());
		setOffset(new Fraction(e, g));
		setOuterNumber(new Fraction(rad.getSimpOutNum(),g));
		setInnerNumber(rad.getSimpInNum());
		
		//Need to write the simplification stuff starting with finishing the faction then to Root then to Quad
		decPosRoot = (Math.pow((double) f, 2) + e) / (double) g ;
		decNegRoot = (Math.pow((double) f, 2) - e) / (double) g ;
		
		
	}

	public void setE(int e) {
		this.e = e;
	}

	public void setF(int f) {
		this.f = f;
	}

	public void setG(int g) {
		this.g = g;
	}
	
	public boolean isImaginary() {
		return imaginary;
	}
	
	public void setImaginary(boolean imag) {
		this.imaginary = imag;
	}
	
	public void setOffset(Fraction offset) {
		this.offset = offset;
	}
	
	public void setOuterNumber(Fraction outerNumber) {
		this.outerNumber = outerNumber;
	}
	
	public void setInnerNumber(int innerNumber) {
		this.innerNumber = innerNumber;
	}

	public double[] getDecimalRoots() {
		double[] roots = {decPosRoot, decNegRoot};
		return roots;
	}
}

package lunarEmpire.math;

public class Fraction {
	int origNumerator;
	int origDenominator;
	int numerator;
	int denominator;
	double decimal;
	
	
	public Fraction (int numerator, int denominator) {
		setOrigNum(numerator);
		setOrigDenom(denominator);
		simplify();
		setDecimal((double)numerator/(double)denominator);
	}
	
	private void simplify(){ //Need a unit test
		/**
		 * Algorithm:
		 * For loop from top to bottom finding the largest common factor
		 * divide each by that factor
		 * return it
		 * NEED TO DO A UNIT TEST ON THIS
		 */
		int highestFactor = 1;
		for(int possFactor = origNumerator;possFactor > 0; possFactor--) {
			if((origNumerator % possFactor == 0) && (origDenominator % possFactor == 0)) {
				highestFactor = possFactor;
				break;
			}
			
			
		}
		setNumerator(this.origNumerator / highestFactor);
		setDenominator(this.origDenominator / highestFactor);
			
	}
	
	public int[] getFraction() {
		int[] fraction = {numerator, denominator};	
		return fraction;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	private void setOrigNum(int num) {
		this.origNumerator = num;
	}
	
	private void setOrigDenom(int denom) {
		this.origDenominator = denom;
	}
	
	private void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	private void setDenominator(int denominator) {
		if(denominator != 0) {
			this.denominator = denominator;
		}
	}
	
	private void setDecimal(double decimal) {
		this.decimal = decimal;
	}
	
	public static Fraction add(Fraction fracOne, Fraction fracTwo) { //Need a unit test
		/*
		 * Get common denominators
		 * add numerators to get a new fraction
		 * run the static simplify
		 * return
		 */
		int fracOneNumer = fracOne.getNumerator() * fracTwo.getDenominator();
		int fracTwoNumer = fracTwo.getNumerator() * fracOne.getDenominator();
		
		int newNumer = fracOneNumer + fracTwoNumer;
		int newDenom = fracOne.getDenominator() * fracTwo.getDenominator();
		
		return new Fraction(newNumer, newDenom);
		
	}
	
	public static Fraction multiply(Fraction fracOne, Fraction fracTwo) { // Need a unit test
		return new Fraction(fracOne.getNumerator() * fracTwo.getNumerator(), fracOne.getDenominator() * fracTwo.getDenominator());
	}
	
	public static Fraction divide(Fraction fracOne, Fraction fracTwo) {
		return Fraction.multiply(fracOne, fracTwo.getReciprocal());
	}
	
	public Fraction getReciprocal() {
		return new Fraction(denominator, numerator);
	}
}

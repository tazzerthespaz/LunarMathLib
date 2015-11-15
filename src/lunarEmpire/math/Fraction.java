package lunarEmpire.math;
/**
 * Class that represents a fraction. 
 * Can perform simple maniputlations such as simplifying, multiplcation,addition, and subtraction
 * @author Malcolm Boyd
 * @version 1.0
 **/
public class Fraction {
	int origNumerator;
	int origDenominator;
	int numerator;
	int denominator;
	double decimal;
	
/**
 * The constructor for a fraction.
 * Automatically sets the original numbers, simplifies, and sets the decimal.
 * @param numerator The numerator of the fraction.
 * @param denominator The denominator of the fraction.
 */
	public Fraction (int numerator, int denominator) {
		setOrigNum(numerator);
		setOrigDenom(denominator);
		simplify();
		setDecimal((double)numerator/(double)denominator);
	}
	
	private void simplify(){
		/*
		 * Algorithm:
		 * For loop from top to bottom finding the largest common factor
		 * divide each by that factor
		 * return it
		 */
		boolean positive = true;
		if(origNumerator < 0) { //Quickly modify it to make it positive for simplification. . .change back later
			positive = false;
			origNumerator *= -1;
		}
		int highestFactor = 1;
		for(int possFactor = origNumerator;possFactor > 0; possFactor--) {
			if((origNumerator % possFactor == 0) && (origDenominator % possFactor == 0)) {
				highestFactor = possFactor;
				break;
			}
		}
		if(!positive) {
			origNumerator *= -1;
		}
		setNumerator(this.origNumerator / highestFactor);
		setDenominator(this.origDenominator / highestFactor);
			
	}

    /**
     * Returns an array representing a fraction, where the first element is the numerator, and the second the denominator.
     *
     * @return int[] An int array representing the fraction. 
     **/
	public int[] getFraction() {
		int[] fraction = {numerator, denominator};	
		return fraction;
	}
	
    /**
     * Returns the denominator of the fraction.
     *
     * @return int The denominator.
     **/
	public int getDenominator() {
		return denominator;
	}
	
    /**
     * Return the numerator of the fraction.
     *
     * @return int The denominator.
     **/
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
	
    /**
     * Return the decimal representation of the fraction.
     *
     * @return double The decimal of the fraction.
     **/
	public double getDecimal() {
		return decimal;
	}
	
    /**
     * Method returning the sum of two fractions.
     *
     * @param fracOne The first fraction.
     * @param fracTwo The second fraction.
     *
     * @return Fraction The sum of the parameters.
     **/
	public static Fraction add(Fraction fracOne, Fraction fracTwo) { 
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
	
    /**
     * Method that subracts two fractions.
     *
     * @param fracOne The first fraction to be subtracted from.
     * @param fracTwo The second fraction to be taken away.
     *
     * @return Fraction The new fraction of fracOne - fracTwo.
     **/
	public static Fraction subtract(Fraction fracOne, Fraction fracTwo) {
		//Should initially be similar to the add class
		int fracOneNumer = fracOne.getNumerator() * fracTwo.getDenominator();
		int fracTwoNumer = fracTwo.getNumerator() * fracOne.getDenominator();
		
		int newNumer = fracOneNumer - fracTwoNumer;
		int newDenom = fracOne.getDenominator() * fracTwo.getDenominator();
		
		return new Fraction(newNumer, newDenom);
	}
	
    /**
     * Method that multiplies two fractions.
     * 
     * @param fracOne The first fraction.
     * @param fracTwo The second fraction.
     *
     * @return Fraction the product of the two fractions.
     **/
	public static Fraction multiply(Fraction fracOne, Fraction fracTwo) { 
		return new Fraction(fracOne.getNumerator() * fracTwo.getNumerator(), fracOne.getDenominator() * fracTwo.getDenominator());
	}
	
    /**
     * Method that divides two fractions by multiplying by the reciprocal.
     *
     * @param fracOne The fraction the be divided from.
     * @param fracTwo The fraction to be dividing.
     **/
	public static Fraction divide(Fraction fracOne, Fraction fracTwo) {
		return Fraction.multiply(fracOne, fracTwo.getReciprocal());
	}
	
    /**
     * A method that gets the reciprocal of the fraction
     *
     * @return Fraction the reciprocal of the fraction.
     **/
	public Fraction getReciprocal() {
		return new Fraction(denominator, numerator);
	}
	
	@Override
	public boolean equals(Object obj) { 
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Fraction)) {
            return false;
        }
        Fraction newObj = (Fraction) obj;
        if((this.numerator == newObj.numerator) && (this.denominator == newObj.denominator)) {
        	return true;
        }else {
        	return false;
		}
	}
	@Override
	public String toString() {
		if(denominator != 1){
			String fractionString = String.valueOf(numerator) + " / " + String.valueOf(denominator);
			return fractionString;
		}else {
			String fractionString = String.valueOf(numerator);
			return fractionString;
		}
		
	}
}

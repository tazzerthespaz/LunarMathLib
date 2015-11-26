package lunarEmpire.math;

import java.math.BigDecimal;

/**
 * Class that represents a fraction. 
 * Can perform simple maniputlations such as simplifying, multiplcation,addition, and subtraction
 * @author Malcolm Boyd
 * @version 1.0
 **/
public class Fraction {
    double origNumerator;
    double origDenominator;
    int origNumerInt; //The integer equivalent of the orig fraction
    int origDenomInt; //The integer equivalent of the orig fraction
    int numerator;
    int denominator;
    double decimal;
    String pow = "Test";    
    /**
     * The constructor for a fraction.
     * Automatically sets the original numbers, simplifies, and sets the decimal.
     * @param numerator Double. The numerator of the fraction.
     * @param denominator Double. The denominator of the fraction.
     */

    public Fraction (double numerator, double denominator) {
        setOrigNum(numerator);
        setOrigDenom(denominator);
        origToFractionInt();
        simplify();
        setDecimal(numerator/denominator);
    }

    private void simplify(){
        /*
         * Algorithm:
         * For loop from top to bottom finding the largest common factor
         * divide each by that factor
         * return it
         */
        boolean positive = true;
        //Quickly modify it to make it positive for simplification. . .change back later
        if(origNumerInt < 0) { 
            positive = false;
            origNumerInt *= -1;
        }
        int highestFactor = 1;
        for(int possFactor = origNumerInt; possFactor > 0; possFactor--) {
            if((origNumerInt % possFactor == 0) && (origDenomInt % possFactor == 0)) {
                highestFactor = possFactor;
                break;
            }
        }
        if(!positive) {
            origNumerInt *= -1; // Move back to negative. . . see earlier comment
        }
        setNumerator(this.origNumerInt / highestFactor);
        setDenominator(this.origNumerInt / highestFactor);

    }

    //TODO test this method and changes
    private void origToFractionInt() {
        //Convert a fraction of doubles to ints, makes the rest of the process easier
        //Multiplies times ten until bottom and top are ints
        BigDecimal nnum = new BigDecimal(this.origNumerator);
        BigDecimal nnum2 = new BigDecimal(this.origDenominator);
        int powerOne = 0;
        int powerTwo = 0;
        BigDecimal tempNum1 = nnum;
        BigDecimal tempNum2 = nnum2;

        while(tempNum1.doubleValue() != (int)tempNum1.doubleValue()) {
            powerOne++;
            tempNum1 = tempNum1.multiply(BigDecimal.TEN);
        }
        while(tempNum2.doubleValue() != (int)tempNum2.doubleValue()) {
            powerTwo++;
            tempNum2 = tempNum2.multiply(BigDecimal.TEN);
        }

        if(powerTwo > powerOne) {
            nnum = nnum.multiply(new BigDecimal(Math.pow(10,(double)powerTwo)) );
            nnum2 = nnum2.multiply((new BigDecimal( Math.pow(10.0,(double)powerTwo) )));
        }else if(powerOne >= powerTwo) {
            nnum = nnum.multiply(new BigDecimal(Math.pow(10,(double)powerOne)) );
            nnum2 = nnum2.multiply((new BigDecimal( Math.pow(10.0,(double)powerOne) )));
        }
        this.origNumerInt = (int)nnum.doubleValue();
        this.origDenomInt = (int)nnum2.doubleValue();
    }

    /**
     * Returns an array representing a fraction, where the first element is the numerator, and the second the denominator.
     *
     * @return int[] An int array representing the fraction. 
     **/
    public double[] getFraction() {
        double[] fraction = {numerator, denominator};   
        return fraction;
    }

    /**
     * Returns the denominator of the fraction.
     *
     * @return int The denominator.
     **/
    public double getDenominator() {
        return denominator;
    }

    /**
     * @return the origNumerInt
     */
    public int getOrigNumerInt() {
        return origNumerInt;
    }

    /**
     * @param origNumerInt the origNumerInt to set
     */
    public void setOrigNumerInt(int origNumerInt) {
        this.origNumerInt = origNumerInt;
    }

    /**
     * @return the origDenomInt
     */
    public int getOrigDenomInt() {
        return origDenomInt;
    }

    /**
     * @param origDenomInt the origDenomInt to set
     */
    public void setOrigDenomInt(int origDenomInt) {
        this.origDenomInt = origDenomInt;
    }

    /**
     * Return the numerator of the fraction.
     *
     * @return int The denominator.
     **/
    public int getNumerator() {
        return numerator;
    }

    private void setOrigNum(double num) {
        this.origNumerator = num;
    }

    private void setOrigDenom(double denom) {
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
        double fracOneNumer = fracOne.getNumerator() * fracTwo.getDenominator();
        double fracTwoNumer = fracTwo.getNumerator() * fracOne.getDenominator();

        double newNumer = fracOneNumer + fracTwoNumer;
        double newDenom = fracOne.getDenominator() * fracTwo.getDenominator();

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
        double fracOneNumer = fracOne.getNumerator() * fracTwo.getDenominator();
        double fracTwoNumer = fracTwo.getNumerator() * fracOne.getDenominator();

        double newNumer = fracOneNumer - fracTwoNumer;
        double newDenom = fracOne.getDenominator() * fracTwo.getDenominator();

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
        return "Original Numerator: " + origNumerator + "\nOriginal Denominator: " + origDenominator + 
            "\nUnsimplified Numerator Int: " + origNumerInt + "\nUnsimplified Denominator Int: " + origDenomInt + 
            "\nSimplified Numerator: " + numerator + "\nSimplified Denominator: " + denominator + "\nDecimal: " + decimal;
    }   
}

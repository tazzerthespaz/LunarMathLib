package lunarEmpire.math;

import java.util.Map;
import java.util.ArrayList;

/**
 * The class that simplifies all radicals.
 * <p>
 * Class takes input as an inner number, outter number, and an index where it simplifies these numbers in the constructor.
 * To use the class create a new instance and call the getSimpInNum() and getSimpOutNum() methods which will return the simplified
 * values of the radical. 
 * 
 * @author Malcolm Boyd
 * @version 1.0
 */

//TODO
//imaginary function ---fix this up and find out wtf is going on with the whole different roots and while loop issue
//decimal
public class Radical {
    private double origInNum;
    private double origOutNum;
    private int root;
    private Fraction unSimpInNum;
    private Fraction unSimpOutNum;
    private int simpInNum;
    private Fraction simpOutNum;
    private boolean imaginary;
    private double decimal;

    /**
     * The constructor for Radical class that fills object's fields and simplifies the a radical.
     *  
     * Runs the simplify method and fills all fields
     * @param inNum
     * @param outNum
     * @param index
     */   
    public Radical(double inNum, double outNum, int root) {
        //Set the class fields
        
        // See if its imaginary
        boolean needsChange = false;
        if(inNum < 0) {
            if (root % 2 != 0) {
                imaginary = false;
                needsChange = true;
            } else {
                imaginary = true;
            }
        }else {
            imaginary = false;
        }

        //avoid infinite loop by making the number positive
        if(inNum < 0) {
            inNum *= -1;
        }

        this.origInNum = inNum;
        this.origOutNum = outNum;
        this.unSimpInNum = new Fraction(inNum, 1);
        this.unSimpOutNum = new Fraction(outNum, 1);
        this.root = root;
        calc();
        if(needsChange) {
            simpOutNum = Fraction.multiply(simpOutNum, new Fraction(-1.0, 1.0));
        }
        calcDecimal();
    }

    //Do all calculations here
    private void calc() {
        Fraction workingInner = this.unSimpInNum;
        Fraction workingOuter = this.unSimpOutNum;

        //Step 1
        ArrayList<Integer> intBottomWork = deRadBottom(workingInner);

        //Combine the new denominator with the outer number
        workingOuter = Fraction.multiply(workingOuter, new Fraction(1.0, (double)intBottomWork.get(1)));

        //Step 2
        int simpInner = intBottomWork.get(0);
        ArrayList<Integer> simplifiedRad = simpIntRad(simpInner);

        //Combine the new outernumbers
        workingOuter = Fraction.multiply(workingOuter, new Fraction((double)simplifiedRad.get(1), 1.0));

        
        //Step 3 set the class fields to the new values
        this.simpOutNum = workingOuter;
        this.simpInNum = simplifiedRad.get(0);
        
    }

    private void calcDecimal() {
        this.decimal = this.simpOutNum.getDecimal() * Math.pow(this.simpInNum, 1.0/root);
    }

    //Now we will re-define how this shit works
    //The outernum is really just a fraction multiplied by an integer radical over one(also a fraction)
    
    //The first step: work with the outer number later, focus on the fraction with a radical in the bottom
    //Multiply the bottom and top by the bottom number: root of(num ^ root-1)
    //So far this looks good
    private ArrayList<Integer> deRadBottom(Fraction inNum) {
        //Do we have the square root of the otp and the bottom?
        int bottom = (int)inNum.getDenominator(); //Can just set the bottom as the new num, have to cast to int even though it should be one
        int unSimpTop = inNum.getNumerator() * (int)Math.pow(inNum.getDenominator(), (double)this.root - 1);

        ArrayList<Integer> finalNums = new ArrayList<Integer>();
        finalNums.add(unSimpTop); //topNum @ (0)
        finalNums.add(bottom); //bottomNum @ (1)
        return finalNums; //Return the end nums in an Arraylist [topNum , bottom]
    }

    //The second step: simplify the only radical left, integer, on the top
    public ArrayList<Integer> simpIntRad(int innerNum) {
        //Takes in an inner number, and outuputs and inner and outer
        int simpOutNum = 1;
        int simpInNum = 1;
        Map<Integer, Integer> dictionary = new BreakerDown(innerNum).getDictionary();

        for(int key : dictionary.keySet() ){
             // If there is enough to take out a set
            if(dictionary.get(key) >= root ){
                // the outer number is multiplied by the taken out groups of numbers
                simpOutNum = (int) (simpOutNum * (Math.pow(key,(int)(dictionary.get(key) / root)))); 
                // the left over numbers that weren't taken out are left in the map
                dictionary.put(key,dictionary.get(key) - (int)(dictionary.get(key) / root) * root); 
            }
            
        }
        for(int key : dictionary.keySet() ) {
            simpInNum *= (Math.pow(key, dictionary.get(key))); //the inner number is equal to the prime**(leftover in hashmap)
        }

        ArrayList<Integer> finalNums = new ArrayList<>();
        finalNums.add(simpInNum); //inner @ [0]
        finalNums.add(simpOutNum); //outer @ [1]

        return finalNums;
    }

    /**
     * @return the origInNum
     */
    public double getOrigInNum() {
        return origInNum;
    }

    /**
     * @return the origOutNum
     */
    public double getOrigOutNum() {
        return origOutNum;
    }

    /**
     * @return the root
     */
    public int getRoot() {
        return root;
    }

    /**
     * @return the unSimpInNum
     */
    public Fraction getUnSimpInNum() {
        return unSimpInNum;
    }

    /**
     * @return the unSimpOutNum
     */
    public Fraction getUnSimpOutNum() {
        return unSimpOutNum;
    }

    /**
     * @return the simpInNum
     */
    public int getSimpInNum() {
        return simpInNum;
    }

    /**
     * @return the simpOutNum
     */
    public Fraction getSimpOutNum() {
        return simpOutNum;
    }

    /**
     * @return the imaginary
     */
    public boolean isImaginary() {
        return imaginary;
    }

    /**
     * @return the decimal
     */
    public double getDecimal() {
        return decimal;
    }

    public String toString() {
        return "Root:" + root + "\nSimpInNum: " + simpInNum + "\nSimpOutNum: " + simpOutNum.toString() + "\nImaginary: " + imaginary + "\nDecimal: " + decimal;
    }
}

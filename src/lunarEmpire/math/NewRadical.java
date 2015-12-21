package lunarEmpire.math;

import java.util.Map;
import java.util.ArrayList;

public class NewRadical {
    //Lets get to work
    private double origInNum;
    private double origOutNum;
    private int root;
    private Fraction unSimpInNum;
    private Fraction unSimpOutNum;
    private int simpInNum;
    private Fraction simpOutNum;
    
    public NewRadical(double inNum, double outNum, int root) {
        //Set the class fields
        this.origInNum = inNum;
        this.origOutNum = outNum;
        this.unSimpInNum = new Fraction(inNum, 1);
        this.unSimpOutNum = new Fraction(outNum, 1);
        this.root = root;
        calc();
        //Run the calculations
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

    //Now we will re-define how this shit works
    //The outernum is really just a fraction multiplied by an integer radical over one(also a fraction)
    
    //The first step: work with the outer number later, focus on the fraction with a radical in the bottom
    //Multiply the bottom and top by the bottom number: root of(num ^ root-1)
    //So far this looks good
    private ArrayList<Integer> deRadBottom(Fraction inNum) {
        //Do we have the square root of the otp and the bottom?
        int bottom = (int)inNum.getDenominator(); //Can just set the bottom as the new num, have to cast to int even though it should be one
        int unSimpTop = inNum.getNumerator() * (int)Math.pow(inNum.getDenominator(), (double)this.root - 1);

        ArrayList finalNums = new ArrayList<Integer>();
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
}

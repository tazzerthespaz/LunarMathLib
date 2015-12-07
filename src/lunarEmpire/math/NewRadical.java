package lunarEmpire.math;

public class NewRadical {
    //Lets get to work
    private double origInNum;
    private double origOutNum;
    private int root;
    private Fraction inNum;
    private Fraction outNum;
    
    public NewRadical(double inNum, double outNum, int root) {
        //Set the class fields
        this.origInNum = inNum;
        this.origOutNum = outNum;
        this.inNum = new Fraction(inNum, 1);
        this.outNum = new Fraction(outNum, 1);
        this.root = root;
        //Run the calculations
    }

    //Now we will re-define how this shit works
    //The outernum is really just a fraction multiplied by an integer radical over one(also a fraction)
    
    //The first step: work with the outer number later, focus on the fraction with a radical in the bottom
    //Multiply the bottom and top by the bottom number: root of(num ^ root-1)
    //So far this looks good
    public void deRadBottom() {
        //Do we have the square root of the otp and the bottom?
        int bottom = (int)inNum.getDenominator(); //Can just set the bottom as the new num, have to cast to int even though it should be one
        int unSimpTop = inNum.getNumerator() * (int)Math.pow(inNum.getDenominator(), (double)this.root - 1);
        System.out.println("New Bottom: " + bottom);
        System.out.println("New Top: " + unSimpTop);
    }

    //The second step: simplify the only radical left, integer, on the top
    private void simpIntRad() {

    }

    //Step 3: Now we have a third outer number in its own fraction like the first
    //Merge this with the former
    //May need to check but the fraction class should simplify this
    private void mergeOuterFractions() {

    }

    //Now we should have the final outer fraction and an integer normal radical, everything simplified
}

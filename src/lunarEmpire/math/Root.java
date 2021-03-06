package lunarEmpire.math;

/**
 * Class that represents a root. Extends fraction.
 *
 * @author Malcolm Boyd
 * @version 1.0
 **/
public class Root extends Fraction {
/*
 * uses:    offset (+/-) √(radicand)
 * 		   -------------------------
 * 		         denominator
 */
	private Fraction offset; //The number added to the radical
	private double radicand; //Non-simplifie d
	private Radical radical; //The real radical that is responsible for everything
	private DecimalRoot positiveDecimal; //Decimal representation TODO: Make this a decimal class
	private DecimalRoot negativeDecimal; //Dido
	private boolean isImaginary = false; // Is the root imaginary (is radicand negative)
	private Fraction simpOffset; // The simplified offset (offset / denom)
	private Fraction simpOuterNumber; //The simplified outer number of the radical (outnum / denom)
	
	
    /**
     * The constructor that sets up the radical, makes calculations and simplifies the radical.
     *
     * @param offset An int that is added to the radical, and divided by the denominator
     * @param radicand An int that is inside the radical.
     * @param denominator The int inside the radical.
     **/
	public Root(Fraction offset, double radicand, double denominator) {
		super(1.0, denominator);
		setNumerator(offset, new Radical(radicand, 1.0, 2));
		if(radical.isImaginary()) {
			isImaginary = true;
		}
		calcDecimal();
		simplify();
	}
	
    /**
     * toString() returns a String representing the class's fields
     * 
     * @return String String of the class's instance fields.
     **/
	public String toString() {
		return "Offset: " + offset +
		    "\nRadicand: " + radicand +
            "\nDenominator " + denominator +
            "\npositiveDecimal: " + positiveDecimal +
            "\nnegativeDecimal: " + negativeDecimal +
            "\nisImaginary:" + isImaginary +
            "\nsimpOffset:" + simpOffset +
            "\nsimpOuterNumber:" + simpOuterNumber;
    }

	private void calcDecimal() {
		//Cant add if imaginary!!!!!
		if(!isImaginary){
			double posNumer = offset.getDecimal() + radical.getDecimal();
			double negNumer = offset.getDecimal()  + (radical.getDecimal() * -1);
			
			positiveDecimal = new RealDecimalRoot(posNumer / (double)denominator);
			negativeDecimal = new RealDecimalRoot(negNumer / (double)denominator);
			
		}else {
            positiveDecimal = new ImaginaryDecimalRoot(offset.getDecimal() / (double) denominator, radical.getDecimal() / (double)denominator);
			negativeDecimal = new ImaginaryDecimalRoot(offset.getDecimal() / (double) denominator, radical.getDecimal()/ (double)denominator  * -1);
		}
	}
	
	private void simplify(){
		Fraction offSetFrac = new Fraction(offset.getDecimal(),denominator);
		Fraction outerNumFrac = new Fraction(radical.getSimpOutNum().getDecimal(), denominator);
		
//		
//		if(offSetFrac.getNumerator() != offset || outerNumFrac.getNumerator() != radical.getSimpOutNum()) { //If Anything has changed
//			simpOffset = offSetFrac;
//			simpOuterNumber = outerNumFrac;
//		}
		simpOffset = offSetFrac;
		simpOuterNumber = outerNumFrac;
        this.radicand = this.radical.getSimpInNum();
		
	}
	
    /**
     * A method that sets of offset of the Root
     * @param offset Int that becomes the offset of the Root.
     **/
	public void setOffset(Fraction offset) {
		this.offset = offset;
	}
	
    /**
     * Method sets the number inside the radical.
     *
     * @param radicand The number inside the radical.
     **/
	public void setRadicand(double radicand) {
		this.radicand = radicand;
	}
		
    /**
     * Sets the entire numerator of the Root
     *
     * @param offset Integer that is the offset
     * @param rad Radical that replaces the radical.
     **/
	public void setNumerator(Fraction offset, Radical rad) {
		setOffset(offset);
		this.radical = rad;
	}
	
    /**
     * Method returns the positive decimal representation of the root.
     *
     * @return double The decimal positive representation of the root.
     **/
	public DecimalRoot getPositiveDecimal() {
		return positiveDecimal;
	}
	
    /**
     * Method returns the negative decimal of the root.
     *
     * @return double The negative decimal of the root.
     **/
	public DecimalRoot getNegativeDecimal() {
		return negativeDecimal;
	}
	
    /**
     * Method gets the radicand.
     *
     * @return int The radicand.
     **/
	public double getRadicand() {
		return radicand;
	}
	
    /**
     * Method gets whether or not the root is imaginary.
     *
     * @return boolean Is the radical imaginary.
     **/
	public boolean getImaginary() {
		return isImaginary;
	}
	
    /**
     * Method gets whether or not the root is simplified.
     *
     * @return boolean Is the radical simplified.
     **/
	public boolean isSimplified(){
		if(simpOffset == null) {
			return false;
		}else {
			return true;
		}
	}

    public Radical getRadical() {
        return this.radical;
    }
	
    public Fraction getSimpOffset() {
        return this.simpOffset;
    }

    public Fraction getSimpOutNum() {
        return this.simpOuterNumber;
    }

    
    /**
     * Method gets a string representation of the positive root
     *
     * @return String The positive representation of the root.
     **/
	public String positiveToString() {
		if(isSimplified()) {
			return "(" + simpOffset + " +" + simpOuterNumber + "√(" + radical.getSimpInNum() + ")";
		} else {
			return "";
		}
	}
	
    /**
     * Method gets a string representation of the negative root.
     *
     * @return String The negative representation of the root.
     **/
	public String negativeToString() {
		if(isSimplified()) {
			return simpOffset + " -" + simpOuterNumber + "√(" + radical.getSimpInNum() + ")";
		} else {
			return "";
		}
	}
	

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Root)) {
	            return false;
		}
		Root newRoot = (Root)obj;
		if(this.getPositiveDecimal() == newRoot.getPositiveDecimal() && this.getNegativeDecimal() == newRoot.getNegativeDecimal()) {
			return true;
		}else{
			return false;
		}
	}
}

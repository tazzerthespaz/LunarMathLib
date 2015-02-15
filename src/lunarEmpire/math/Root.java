package lunarEmpire.math;

import lunarEmpire.math.Radical;

public class Root extends Fraction {
/*
 * uses:    offset (+/-) √(radicand)
 * 		   -------------------------
 * 		         denominator
 */
	private int offset;
	private int radicand;
	private Radical radical;
	private Double positiveDecimal;
	private Double negativeDecimal;
	private boolean isImaginary = false;
	
	
	
	public Root(int offset, int radicand, int denominator) {
		super(1, denominator);
		setNumerator(offset, new Radical(radicand, 1, 2));
		if(radical.isImaginary()) {
			isImaginary = true;
		}
		calcDecimal();
		
	}
	

	private void calcDecimal() {
		//Cant add if imaginary!!!!!
		if(!isImaginary){
			double posNumer = (double)offset + radical.getPosDecimal();
			double negNumer = (double)offset  + radical.getNegDecimal();
			
			positiveDecimal = posNumer / (double)denominator;
			negativeDecimal = negNumer / (double)denominator;
			
		}else {
			positiveDecimal = null;
			negativeDecimal = null;
		}
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public void setRadicand(int radicand) {
		this.radicand = radicand;
	}
		
	public void setNumerator(int offset, Radical rad) {
		setOffset(offset);
		this.radical = rad;
	}
	
	public double getPositiveDecimal() {
		return positiveDecimal;
	}
	
	public double getNegativeDecimal() {
		return negativeDecimal;
	}
	
	public int getRadicand() {
		return radicand;
	}
	
	public boolean getImaginary() {
		return isImaginary;
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

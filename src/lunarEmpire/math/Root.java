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
	private double positiveDecimal;
	private double negativeDecimal;
	
	
	
	public Root(int offset, int radicand, int denominator) {
		super(1, denominator);
		setNumerator(offset, new Radical(radicand, 1, 2));
		calcDecimal();
	}
	

	private void calcDecimal() {
		double posNumer = (double)offset + radical.getPosDecimal();
		double negNumer = (double)offset  + radical.getNegDecimal();
		
		positiveDecimal = posNumer / (double)denominator;
		negativeDecimal = negNumer / (double)denominator;
		
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
	
}

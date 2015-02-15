package lunarEmpire.math;
/**
 * Class for working with quadratic equations
 * @author Malcolm Boyd
 *
 */

// y = ax**2 + bx + c
public class Quadratic {
	private int a;
	private int b;
	private int c;
	
	Quadratic(int a, int b, int c) {
		setA(a);
		setB(b);
		setC(c);
	}
	
	
	//All of the things that you would have to solve for
	public double[] getVertex() {
		// -b/2a gives the axis of symmetry
		// 0 = ax^2 + bx + c
		double xVal = (b * -1) / (double)(2 * a);
		double yVal = this.a * Math.pow(xVal, 2) + this.b * xVal + this.c * xVal;
		double[] vertex = {xVal, yVal};
		return vertex;
	}

	public double getAxisSymmetry() {
		return (b * -1) / (double)(2 * a); 
	}
	
	public Root getRoots() { //Need Unit test
		//Create Root Class need to solve for the roots here
		Root roots = new Root(b * -1,b * b - (4 * a * c), 2 * a); //pass in the e , f , and g -b +- sqrt(b**2 - 4ac) //2a
		return roots;
	}
	
	public double getPoint(double x) {
		double y = getA() * (Math.pow(x, 2)) + b * x + c;
		return y;
	}
	
	//All of the getter and setters
 	public void setA(int a) {
		if(a != 0) {
			this.a = a;
		}	
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public void setC(int c) { 
		this.c = c;
	}
	
	public int getA() {
		return this.a;
	}
	
	public int getB() {
		return this.b;
	}
	
	public int getC() {
		return this.c;
	}
}

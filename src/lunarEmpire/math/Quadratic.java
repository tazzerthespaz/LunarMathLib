package lunarEmpire.math;

/**
 * Class for working with quadratic equations
 * @author Malcolm Boyd
 * @version 1.0
 */
public class Quadratic {
// y = ax**2 + bx + c
	private int a;
	private int b;
	private int c;
	private Root roots;
	
    /**
     * The constructor setting all variables and calculates the roots.
     **/
	public Quadratic(int a, int b, int c) {
		setA(a);
		setB(b);
		setC(c);
		calcRoots();
	}
	
    /**
     * Gets the coordinate of the vertex.
     *
     * @return double[] The x,y of the vertex.
     **/
	public double[] getVertex() {
		// -b/2a gives the axis of symmetry
		// 0 = ax^2 + bx + c
		double xVal = (b * -1) / (double)(2 * a);
		double yVal = this.a * Math.pow(xVal, 2) + this.b * xVal + this.c * xVal;
		double[] vertex = {xVal, yVal};
		return vertex;
	}

    /**
     * Gets the axis of symmetry.
     *
     * @return double The axis of symmetry.
     **/
	public double getAxisSymmetry() {
		return (b * -1) / (double)(2 * a); 
	}
	
    /**
     *  Updates the roots after class is assigned new values.
     **/
	public void calcRoots() {
		int offset = b * -1;
		int radicand = b * b - (4 * a * c);
		int denominator = 2 * a;
		roots = new Root(offset, radicand, denominator);
	}
	
    /**
     * Gets the y point from the parameter x value.
     * @param double The x input value.
     * @return double The y output value.
     **/
	public double getPoint(double x) {
		double y = getA() * (Math.pow(x, 2)) + b * x + c;
		return y;
	}
	
    /**
     * Sets the a value of the equation.
     *
     * @param int The a value of the equation.
     **/
 	public void setA(int a) {
		if(a != 0) {
			this.a = a;
		}	
	}
	
    /**
     * Sets the B value of the equation.
     *
     * @param int The b value of the equation.
     **/
	public void setB(int b) {
		this.b = b;
	}
	
    /**
     * Sets the c value of the equation.
     *
     * @param int The C value of the equation.
     **/
	public void setC(int c) { 
		this.c = c;
	}
	
    /**
     * Gets the A value of the equation.
     *
     * @return int The A value of the equation.
     **/
	public int getA() {
		return this.a;
	}
	
    /**
     * Gets the B value of the equation.
     *
     * @return int The B value of the equation.
     **/
	public int getB() {
		return this.b;
	}
	
    /**
     * Gets the C value of the equation.
     *
     * @return int The C value of the equation.
     **/
	public int getC() {
		return this.c;
	}

    /**
     * Gets the roots of the quadratic.
     *
     * @return Root The roots of the equation.
     **/
	public Root getRoots() {
		return roots;
	}
}

package lunarEmpire.math;

/**
 * Class for working with quadratic equations
 * @author Malcolm Boyd
 * @version 1.0
 */
public class Quadratic {
// y = ax**2 + bx + c
	private double a;
	private double b;
	private double c;
	private Root roots;
	
    /**
     * The constructor setting all variables and calculates the roots.
     **/
	public Quadratic(double a, double b, double c) throws AIsZeroException {
        if(a == 0.0) {
            throw new AIsZeroException();
        }
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
		double xVal = (b * -1) / (2 * a);
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
		return (b * -1) / (2 * a); 
	}
	
    /**
     *  Updates the roots after class is assigned new values.
     **/
	public void calcRoots() {
		Fraction offset = new Fraction((b * -1), 1); //TODO may need to check the math on this one
		double radicand = b * b - (4 * a * c); //TODO figure out a way to fix this shit probably make it so that Radical doesn't simplify doubles
		double denominator = 2 * a;
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
     * @param double The a value of the equation.
     **/
 	public void setA(double a) {
		if(a != 0) {
			this.a = a;
		}	
	}
	
    /**
     * Sets the B value of the equation.
     *
     * @param double The b value of the equation.
     **/
	public void setB(double b) {
		this.b = b;
	}
	
    /**
     * Sets the c value of the equation.
     *
     * @param double The C value of the equation.
     **/
	public void setC(double c) { 
		this.c = c;
	}
	
    /**
     * Gets the A value of the equation.
     *
     * @return double The A value of the equation.
     **/
	public double getA() {
		return this.a;
	}
	
    /**
     * Gets the B value of the equation.
     *
     * @return double The B value of the equation.
     **/
	public double getB() {
		return this.b;
	}
	
    /**
     * Gets the C value of the equation.
     *
     * @return double The C value of the equation.
     **/
	public double getC() {
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



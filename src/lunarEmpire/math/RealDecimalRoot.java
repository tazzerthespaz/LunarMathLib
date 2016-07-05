package lunarEmpire.math;

/**
 * A class that represents a real, non-complex, decimal root.
 * @author Malcolm Boyd
 * @version 1.1
 **/
public class RealDecimalRoot implements DecimalRoot{
    private double root;
    
    /**
     * Takes and sets the root to be represented.
     * @param double The only portion of the root to be represented.
     **/
    public RealDecimalRoot(double root) {
        this.root = root;
    }

    /**
     * @return The root
     **/
    public double getRoot() {
        return this.root;
    }

    //Implementation
    public String toString() {
        return String.valueOf(root);
    }
}

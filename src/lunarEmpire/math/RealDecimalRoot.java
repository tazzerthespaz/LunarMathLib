package lunarEmpire.math;

public class RealDecimalRoot implements DecimalRoot{
    private double root;
    
    public RealDecimalRoot(double root) {
        this.root = root;
    }

    //Implementation
    public String toString() {
        return String.valueOf(root);
    }
}

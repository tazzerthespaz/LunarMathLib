package lunarEmpire.math;

/**
 * This is an exception for when a = 0 in a quadratic, equation, making it a linear equation
 * @author Malcolm Boyd
 * @version .1
 **/
public class AIsZeroException extends Exception {

    public AIsZeroException() {
        super();
    }

    public AIsZeroException(String message) {
        super(message);
    }
    
}

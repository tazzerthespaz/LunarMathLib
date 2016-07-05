package lunarEmpire.math;

//May want to truncate or round stuff
/**
 * Constructor of a representation of a complex root in decimal form.
 * @author Malcolm Boyd
 * @version 1.1
 **/
public class ImaginaryDecimalRoot implements DecimalRoot {
    double realPart;
    double imaginaryPart;

    /**
     * Constructor, takes the real part and the following imaginary part.
     * @param double The real portion of the complex number.
     * @param double The imaginary portion of the complex number.
     **/
    public ImaginaryDecimalRoot(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * @return the realPart
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * @param realPart the realPart to set
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    /**
     * @return the imaginaryPart
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * @param imaginaryPart the imaginaryPart to set
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public String toString() {
        return String.valueOf(realPart) + " + " + String.valueOf(imaginaryPart) + "i";
    }

}

package lunarEmpire.math;

//May want to truncate or round stuff
public class ImaginaryDecimalRoot implements DecimalRoot {
    double realPart;
    double imaginaryPart;

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

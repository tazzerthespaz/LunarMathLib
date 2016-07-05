package lunarEmpire.math;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Class that used for viewing and formatting the output of DecimalRoots.
 * Will take either an imaginary or real. Can further be used to show rounded
 * decimals.
 * @author Malcolm Boyd
 * @version 1.1
 **/
public class DecimalRootDisplay {
    ImaginaryDecimalRoot idr = null;

    /**
     * Takes any DecimalRoot object.
     * @param DecimalRoot The root to be displayed.
     **/
    public DecimalRootDisplay(DecimalRoot dr) {
        if(RealDecimalRoot.class.isInstance(dr)) {
            RealDecimalRoot rdr = (RealDecimalRoot) dr;
            idr = new ImaginaryDecimalRoot(rdr.getRoot(), 0);
        }else {
            idr = (ImaginaryDecimalRoot) dr;
        }
    }
    
    /**
     * Gets the raw, unformatted representation of the root.
     * @return String
     **/
    public String getRaw() {
        String rawString = "";
        rawString += idr.getRealPart();

        if(idr.getImaginaryPart() != 0) {
            rawString += " + " + idr.getImaginaryPart(); 
        }

        return rawString;
    }

    /**
     * Gets the String representation of the root with the arguments 
     * number of decimal places.
     * @param int How many decimal places.
     * @return The formatted String
     **/
    public String getRounded(int places) {
        DecimalFormat df = new DecimalFormat(getFormatString(places));
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        String finalString = "";
        
        //Do the first number
        Double n = new Double(idr.getRealPart());
        finalString += df.format(n); 

        //If imaginary exists
        if(idr.getImaginaryPart() != 0) {
            Double a = new Double(idr.getImaginaryPart());
            finalString += " + " + df.format(a) + "i";
        }
        return finalString;
    }

    private String getFormatString(int places) {
        String fs = "#.";
        for(int i = 0; i < places; i++) {
            fs += "#";
        }
        return fs;
    }
}

package utilities;

import java.text.DecimalFormat;

public class DecimalFormater {

    public static String format(Double number) {
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        return f.format(number);
    }

}

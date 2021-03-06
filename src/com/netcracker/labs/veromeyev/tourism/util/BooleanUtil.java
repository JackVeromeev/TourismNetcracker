package com.netcracker.labs.veromeyev.tourism.util;

/**
 * Contains different methods to work with boolean
 * Created by jack on 23/03/17.
 */
public class BooleanUtil {
    /**
     * Converts boolean variable into integer.
     * True converts to 1, False - to 0
     * @param param boolean variable to transform
     * @return integer equivalent
     */
    public static int toInt(boolean param) {
        return param ? 1 : 0;
    }

    /**
     * Converts boolean variable to Strings
     * True converts to "yes", False - to "no"
     * @param param boolean variable to transform
     * @return string yes/no equivalent
     */
    public static String toYN(boolean param) {
        return param ? "yes" : "no";
    }

    /**
     * Converts boolean variable to Strings
     * True converts to "yes", False - to "no".
     * if firstLetterUp is set as true output strings
     * will be "Yes" and "No"
     * @param param boolean variable to transform
     * @param firstLetterUp if true, first letter of string will be uppercase
     * @return result string
     */
    public static String toYN(boolean param, boolean firstLetterUp) {
        String result = toYN(param);
        if (firstLetterUp) {
            return result.replace('y', 'Y').replace('n', 'N');
        } else {
            return result;
        }
    }

}

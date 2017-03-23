
/**
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
        return Boolean.compare(param, false);
    }

    /**
     * Converts boolean variable to Strings
     * True converts to "yes", False - to "no"
     * @param param boolean variable to transform
     * @return string yes/no equivalent
     */
    public static String toYN(boolean param) {
        if (param) {
            return "yes";
        } else {
            return "no";
        }
    }

    /**
     * Converts boolean variable to Strings
     * True converts to "yes", False - to "no".
     * if firstLetterUp is set as true outcoming strings
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

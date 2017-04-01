package com.netcracker.labs.veromeyev.tourism.util;

public class StringUtil {

    /**
     * Appends string to the stringBuilder if it already
     * contains something. Otherwise nothing happens.
     * @param builder stringBuilder that appends
     * @param toAppend string that should be appended
     * @return incoming stringBuilder (made to save pipeline of simple
     * StringBuilder.append() )
     */
    public static StringBuilder appendIfNotEmpty(StringBuilder builder, String toAppend) {
        if (builder.length() > 0) {
            builder.append(toAppend);
        }
        return builder;
    }
}
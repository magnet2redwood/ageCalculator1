package com.redwood2magnet.ageCalculator.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TextUtil {

    // Converts words to TitleCase. E.g. converts: title case to Title Case
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public String TitleCase(String text) {
        String text2 = text.trim();
        if (text2.isEmpty()) {
            return text2;
        }
        new ArrayList();
        String result = "";
        for (String aWord : text2.split("\\s+")) {
            result = result + " " + Character.toTitleCase(aWord.charAt(0)) + aWord.substring(1);
        }
        if (!result.isEmpty()) {
            result = result.substring(1);
        }
        return result;
    }

    //Reverses the text
    public String Reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    //Compares text1 and text2 and returns true if equal. If ignoreCase is true, it ignores the case
    public boolean Equals(String text1, String text2, boolean ignoreCase) {
        if (ignoreCase) {
            return text1.equalsIgnoreCase(text2);
        }
        return text1.equals(text2);
    }
    //Formats a numeric text with thousand separator using current Locale.
    // Use numDecimals to specify number of decimals. If text is NOT numeric, returns itself
    public String FormatThousandSeparator(String text, int numDecimals) {
        String text2 = text.trim();
        if (!isNumeric(text2)) {
            return text2;
        }
        char[] chars = new char[numDecimals];
        Arrays.fill(chars, '#');
        String strNumDecimals = new String(chars);
        return (numDecimals == 0 ? new DecimalFormat("#,###") : new DecimalFormat("#,###." + strNumDecimals)).format(Double.parseDouble(text2));
    }

    private boolean isNumeric(String text2) {
        try {
            Float.parseFloat(text2);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //A regular expression is a special text string for describing a search pattern. You can think of regular expressions as wildcards on steroids
    public String ReplaceRegex(String text, String regexExpression, String replaceWith) {
        String str = "";
        return Pattern.compile(regexExpression).matcher(text).replaceAll(replaceWith);
    }
}

package com.redwood2magnet.ageCalculator.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {
    //Returns current date and/or time in specified format.
    // Examples are: yyyy.MM.dd G HH:mm:ss z. Where MM is month or MMM is 3 char mont, HH is 24hr time and hh is 12hr time
    public String FormatCurrentDateTime(String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
    }

    //Returns days, hours, minutes, seconds between 2 dates. Note that dates have to have same format
    public String[] TimeDiff(String dateStart, String dateEnd, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        try {
            long diff = simpleDateFormat.parse(dateEnd).getTime() - simpleDateFormat.parse(dateStart).getTime();
            long diffSeconds = (diff / 1000) % 60;
            long diffMinutes = (diff / 60000) % 60;
            long diffHours = (diff / 3600000) % 24;
            long diffDays = diff / 86400000;
            DateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            dateTimeFormat.setLenient(true);
            new GregorianCalendar().setTime(dateTimeFormat.parse(dateStart));
            new GregorianCalendar().setTime(dateTimeFormat.parse(dateEnd));
            String[] s1= new String[]{diffDays + "", diffHours + "", diffMinutes + "", diffSeconds + ""};
            return s1;
        } catch (Exception e) {
            String[] s2 = new String[]{"Error,in,conversion," + e.getMessage(), "0", "0", "0"};
            return s2;
        }
    }

}


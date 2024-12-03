package br.jean.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static Date stringToDate(String dateAsString) {
        return stringToDate(dateAsString, "dd/MM/yyyy");
    }

    public static Date stringToDate(String dateAsString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateAsString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static int diferencaEmAnos(Date d1, Date d2) {
        Calendar d2Cal = getCalendar(d2);
        Calendar d1Cal = getCalendar(d1);
        int diff = d1Cal.get(Calendar.YEAR) - d2Cal.get(Calendar.YEAR);
        if (d2Cal.get(Calendar.MONTH) > d1Cal.get(Calendar.MONTH) ||
                (d2Cal.get(Calendar.MONTH) == d1Cal.get(Calendar.MONTH) &&
                        d2Cal.get(Calendar.DATE) > d1Cal.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }
}

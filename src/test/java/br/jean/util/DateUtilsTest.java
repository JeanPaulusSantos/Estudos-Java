package br.jean.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilsTest {

    @Test
    void stringToDate() throws ParseException {

        GregorianCalendar gc = new GregorianCalendar();

        gc.set(Calendar.YEAR, 2023);
        gc.set(Calendar.MONTH, 10); // Mes comça em zero, portando 10 = novembro
        gc.set(Calendar.DATE, 13);
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);

        String dateToConvert = "13/11/2023";

        assertEquals(DateUtils.stringToDate(dateToConvert), gc.getTime());

    }

    @Test
    @DisplayName("Test String To Date With Default Format")
    void testStringToDateWithDefaultFormat() {
        String dateString = "25/12/2023";
        Date date = DateUtils.stringToDate(dateString);

        assertNotNull(date, "Date should not be null");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(25, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(11, calendar.get(Calendar.MONTH)); // Months are 0-indexed
        assertEquals(2023, calendar.get(Calendar.YEAR));
    }

    @Test
    @DisplayName("Test String To Date With Custom Format")
    void testStringToDateWithCustomFormat() {
        String dateString = "2023-12-25";
        String format = "yyyy-MM-dd";
        Date date = DateUtils.stringToDate(dateString, format);

        assertNotNull(date, "Date should not be null");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(25, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(11, calendar.get(Calendar.MONTH));
        assertEquals(2023, calendar.get(Calendar.YEAR));
    }

    @Test
    @DisplayName("Test String To Date Invalid Date")
    void testStringToDateInvalidDate() {
        String invalidDateString = "invalid-date";
        Date date = DateUtils.stringToDate(invalidDateString);
        assertNull(date, "Date should be null for invalid input");
    }

    @Test
    @DisplayName("Test Get Calendar")
    void testGetCalendar() {
        String dateString = "25/12/2023";
        Date date = DateUtils.stringToDate(dateString);
        assertNotNull(date, "Date should not be null");

        Calendar calendar = DateUtils.getCalendar(date);
        assertNotNull(calendar, "Calendar should not be null");
        assertEquals(25, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(11, calendar.get(Calendar.MONTH));
        assertEquals(2023, calendar.get(Calendar.YEAR));
    }

    @Test
    @DisplayName("Test Diferenca Em Anos")
    void testDiferencaEmAnos() {
        String date1String = "01/01/2023";
        String date2String = "01/01/2020";
        Date date1 = DateUtils.stringToDate(date1String);
        Date date2 = DateUtils.stringToDate(date2String);

        assertNotNull(date1, "Date1 should not be null");
        assertNotNull(date2, "Date2 should not be null");

        int difference = DateUtils.diferencaEmAnos(date1, date2);
        assertEquals(3, difference, "Difference in years should be 3");
    }

    @Test
    @DisplayName("Test Diferenca Em Anos With Partial Year")
    void testDiferencaEmAnosWithPartialYear() {
        String date1String = "01/01/2023";
        String date2String = "31/12/2022";
        Date date1 = DateUtils.stringToDate(date1String);
        Date date2 = DateUtils.stringToDate(date2String);

        assertNotNull(date1, "Date1 should not be null");
        assertNotNull(date2, "Date2 should not be null");

        int difference = DateUtils.diferencaEmAnos(date1, date2);
        assertEquals(0, difference, "Difference in years should be 0");
    }
}
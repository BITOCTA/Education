import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtilsTest {

    SimpleDateFormat sdf;

    @Before
    public void setUp() throws Exception {
        sdf = new SimpleDateFormat("dd.MM.yyyy");

    }

    @Test
    public void isFriday13() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Assert.assertTrue(CalendarUtils.isFriday13(sdf.parse("13.09.2019")));
            Assert.assertFalse(CalendarUtils.isFriday13(sdf.parse("13.10.2019")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDateFromDate() {
        try {
            //03.11.2019
            Assert.assertEquals(CalendarUtils.getDateFromDate(sdf.parse("01.01.2019")), "0 years 10 months 2 days");
            Assert.assertEquals(CalendarUtils.getDateFromDate(sdf.parse("02.12.2017")), "1 years 11 months 1 days");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDateFromDate_future_date_param_should_return_exception() {
        try {
            CalendarUtils.getDateFromDate(sdf.parse("02.02.2020"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void gregorian_calendar_minimum_exception() {
        CalendarUtils.gregorianCalendarYearCheck(GregorianCalendar.getInstance().getActualMinimum(Calendar.YEAR)-1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void gregorian_calendar_maximum_exception() {
        CalendarUtils.gregorianCalendarYearCheck(GregorianCalendar.getInstance().getActualMaximum(Calendar.YEAR)+1);

    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextDayCalculatorTest {

    @Test
    void nextDayday1() {
        int day=1;
        int month=1;
        int year=2018;
        String expected=2+"/"+1+"/"+2018;

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday31() {
        int day=31;
        int month=1;
        int year=2018;
        String expected=1+"/"+2+"/"+2018;

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday32month135781012() {
        int day=32;
        int month=1;
        int year=2018;
        String expected="Ngay khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday31month46911() {
        int day=31;
        int month=4;
        int year=2018;
        String expected="Ngay khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday30Month2Leapyear() {
        int day=30;
        int month=2;
        int year=2020;
        String expected="Ngay khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday29Month2NotLeapyear() {
        int day=29;
        int month=2;
        int year=2019;
        String expected="Ngay khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday30() {
        int day=30;
        int month=4;
        int year=2018;
        String expected=1+"/"+5+"/"+2018;

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday28() {
        int day=28;
        int month=2;
        int year=2018;
        String expected=1+"/"+3+"/"+2018;

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday29() {
        int day=29;
        int month=2;
        int year=2020;
        String expected=1+"/"+3+"/"+2020;

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDaydayNegative29() {
        int day=-29;
        int month=2;
        int year=2020;
        String expected="Ngay khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDayday0() {
        int day=0;
        int month=2;
        int year=2020;
        String expected="Ngay khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDaymonth12() {
        int day=31;
        int month=12;
        int year=2018;
        String expected=1+"/"+1+"/"+2019;

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDaymonth13() {
        int day=31;
        int month=13;
        int year=2018;
        String expected="Thang khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDaymonth0() {
        int day=31;
        int month=0;
        int year=2018;
        String expected="Thang khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

    @Test
    void nextDaymonthNegative1() {
        int day=31;
        int month=-1;
        int year=2018;
        String expected="Thang khong dung";

        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected, result);
    }

}
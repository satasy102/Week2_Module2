public class NextDayCalculator {

    public static String nextDay(int day, int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10: {
                if (0 < day && day < 30) day = day + 1;
                else if (day==31){
                    day=1;
                    month+=1;
                } else return "Ngay khong  dung";
                break;
            }
            case 12: {
                if (0 < day && day < 30) day  += 1;
                else if (day==31){
                    day=1;
                    month=1;
                    year+=1;
                } else return "Ngay khong  dung";
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                if (0 < day && day < 29) day += 1;
                else if(day==30){
                    day=1;
                    month+=1;
                }else return "Ngay khong  dung";
                break;
            }
            case 2: {
                if(isLeapYear(year)){
                    if(0<day && day <29) day+=1;
                    else if(day==29){
                        day=1;
                        month=3;
                    } else return "Ngay khong dung";
                } else {
                    if(0<day && day <28) day+=1;
                    else if(day==28){
                        day=1;
                        month=3;
                    } else return "Ngay khong dung";
                }
                break;
            }
            default: return "Thang khong dung";
        }
        return day + "/" + month + "/" + year;
    }

    public static boolean isLeapYear(int year){
        boolean isLeapYear = false;

        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }
}

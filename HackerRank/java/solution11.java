import java.util.*;
import java.time.LocalDate; import java.time.format.TextStyle; import java.util.Locale;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        int gun=6+day;
        gun+=dayMonth(month, year);
        gun+=dayForYear(year);
        
        Date last= new Date(year, month, year);
        int a=last.compareTo(new Date(1,1,2000));
        System.out.println(a);
        LocalDate date = LocalDate.of(year, month, day); 
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
        
        
    }
    
    public static int dayMonth(int b, int year){
        int result=0;
        b--;
        if(b>-1){
        while (b!=0) {
            result+=dayForMonth(b, year);
            b--;
        }
        }
        return result;
    }
    
    public static int dayForMonth(int m, int year){
        switch(m){
            case(1):
                return 31;
            case(2):
               if(isYeapyear(year))
                return 29;
                else return 28;
            case(3):
                return 31;
            case(4):
                return 30;
            case(5):
                return 31;
            case(6):
                return 30;
            case(7):
                return 31;
            case(8):
                return 31;
            case(9):
                return 30;
            case(10):
                return 31;
            case(11):
                return 30;
            case(12):
                return 31;
            default: return 0;
        }
    }
    
    public static int dayForYear(int year){
        int result=0;
        for (int i = 0; i < year-2000; i++) {
            if(isYeapyear(year))
                result+=365;
            else result+=364;
        }
        return result;
    }
    
    public static boolean isYeapyear(int year){
        if(year%4==0)
            return true;
        else if(year%400==0){
            if(year%100==0)
                return false;
            return true;
        }
        else return false;
    }
    
    public static String day(int day){
        switch(day){
            case(1):
                return "MONDAY";
                case(2):
                return "TUESDAY";
                case(3):
                return "WEDNESDAY";
                case(4):
                return "THURSDAY";
                case(5):
                return "FRIDAY";
                case(6):
                return "SATURDAY";
                default:
                return "SUNDAY";
        }
    }

}

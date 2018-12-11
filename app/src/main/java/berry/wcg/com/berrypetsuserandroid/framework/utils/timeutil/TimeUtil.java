package berry.wcg.com.berrypetsuserandroid.framework.utils.timeutil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wcg on 2018/3/10.
 */

public class TimeUtil {
    private static String tag = "TimeUtil";

    /**
     * @param y year
     * @param m month
     * @param d day
     * @return 0为星期1, 6为星期日
     */
    public static int WeekDay(int y, int m, int d) {
        String date = y + "-" + m + "-" + d;
        if (m == 1) {
            m = 13;
            y--;
        }
        ;
        if (m == 2) {
            m = 14;
            y--;
        }
        ;
        int week = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
        return week;
    }

    //true 闰年 false 平年
    public static boolean isleapyear(int year) {
        if ((year % 400) == 0)
            return true;
        else if ((year % 4) == 0) {
            if ((year % 100) == 0)
                return false;
            else
                return true;
        } else
            return false;
    }

    public static int getmonthdays(int year, int month) {
        String[] months_big = {"1", "3", "5", "7", "8", "10", "12"};
        String[] months_little = {"4", "6", "9", "11"};
        final List<String> list_big = Arrays.asList(months_big);
        final List<String> list_little = Arrays.asList(months_little);
        if (list_big.contains(String.valueOf(month))) {
            return 31;
        } else if (list_little.contains(String.valueOf(month))) {
            return 30;
        } else {
            if (isleapyear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
    }

    /**
     * @param yeara
     * @param montha
     * @param daya
     * @param yearb
     * @param monthb
     * @param dayb
     * @return date b - date a days
     */
    public static int dayscoutn(int yeara, int montha, int daya, int yearb, int monthb, int dayb) {
        int daysa = 0;
        int daysb = 0;
        if (yeara == yearb) {
            for (int i = 1; i < montha; i++) {
                daysa += getmonthdays(yeara, i);
            }
            daysa += daya;
            for (int i = 1; i < monthb; i++) {
                daysb += getmonthdays(yearb, i);
            }
            daysb += dayb;
        } else {
            if (yeara < yearb) {
                for (int i = yeara; i < yearb; i++) {
                    if (isleapyear(i)) {
                        daysb += 366;
                    } else {
                        daysb += 365;
                    }
                }
                for (int i = 1; i < montha; i++) {
                    daysa += getmonthdays(yeara, i);
                }
                daysa += daya;
                for (int i = 1; i < monthb; i++) {
                    daysb += getmonthdays(yearb, i);
                }
                daysb += dayb;
            } else {
                //yeara>yearb
                for (int i = yearb; i < yeara; i++) {
                    if (isleapyear(i)) {
                        daysb -= 366;
                    } else {
                        daysb -= 365;
                    }
                    for (int j = 1; j < monthb; j++) {
                        daysb += getmonthdays(yearb, j);
                    }
                    daysb += dayb;
                    for (int j = 1; j < montha; j++) {
                        daysa += getmonthdays(yeara, j);
                    }
                    daysa += daya;
                }
            }
        }
//        Log.i(tag, yeara + ":" + montha + ":" + daya + ":" + yearb + ":" + monthb + ":" + dayb + ":"+(daysb - daysa));

        return daysb - daysa;
    }
}

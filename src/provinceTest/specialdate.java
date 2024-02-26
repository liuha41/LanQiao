package provinceTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class specialdate {

    public static void main(String[] args) {
/*        LocalDate startDate = LocalDate.of(1900, 1, 1);
        LocalDate endDate = LocalDate.of(9999, 12, 31);
        List<String> dateList = getDateList(startDate, endDate);
        int count =0 ;

        for (String s : dateList) {
            int year = 0, month = 0, day = 0;
            String[] split = s.split("-");
            for (int i = 0; i < split[0].length(); i++) {
                year += Integer.parseInt(String.valueOf(split[0].charAt(i)));
            }
            for (int i = 0; i < split[1].length(); i++) {
                month += Integer.parseInt(String.valueOf(split[1].charAt(i)));
            }
            for (int i = 0; i < split[2].length(); i++) {
                day += Integer.parseInt(String.valueOf(split[2].charAt(i)));
            }
            if (year == month + day) count++;
        }

        System.out.println(count);*/

        int year = 1900; //年
        int mon = 1; //月
        int day = 1; //日
        int month[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        while (true) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) { //先判断是否为闰年
                month[2] = 29; //是的话2月有29天
            } else {
                month[2] = 28; //不是的话2月有28天，一定要加这个else，否则闰年过后2月还是29天，没改回来
            }
            if (year / 1000 + year / 100 % 10 + year / 10 % 10 + year % 10 == mon % 10 + mon / 10 + day % 10
                    + day / 10) { //把年份的每一位拆解，月份和天也拆解，判断是否数位相加之后相等
                count++;
            }
            day++;
            if (day > month[mon]) { //如果天数大于这个月的具体天数，则天数归1，月份+1
                day = 1;
                mon++;
                if (mon > 12) { //月份如果大于了12，就表示该进入下一年，月份归1，年份+1
                    mon = 1;
                    year++;
                }
            }
            if (year == 9999 && mon == 12 && day == 31) { //到这个日期停止，手动算一下这天不符合题目要求，就直接跳出while循环
                break;
            }
        }
        System.out.println(count); //输出结果

    }

    public static List<String> getDateList(LocalDate startDate, LocalDate endDate) {
        List<String> result = new ArrayList<>();
        if (endDate.compareTo(startDate) < 0) {
            return result;
        }

        while (true) {
            result.add(startDate.toString());
            if (startDate.compareTo(endDate) >= 0) {
                break;
            }
            startDate = startDate.plusDays(1);
        }
        return result;
    }

}


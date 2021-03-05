import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;

public class TestDemo {

    public static void main(String[] args) {

        OffsetDateTime dateNow = OffsetDateTimeUtils.getDateNow();
        System.out.println(dateNow.getMonth());
        int year = dateNow.getYear();
        int monthValue = dateNow.getMonthValue();
        OffsetDateTime dateTime = OffsetDateTimeUtils.getFirstDayOfMonth(year, monthValue);
        OffsetDateTime lastDayOfMonth = OffsetDateTimeUtils.getLastDayOfMonth(year, monthValue);
        System.out.println(lastDayOfMonth);
        System.out.println(dateTime);
//        System.out.println(dateNow);
//        OffsetDateTime offsetDateTime = dateNow.minusDays(2);
//        System.out.println(offsetDateTime);
//        OffsetDateTime offsetDateTimes = dateNow.minusWeeks(1);
//        System.out.println(offsetDateTimes);
//        System.out.println(dateNow.compareTo(offsetDateTime));

        // 当前时间 对比 截止日期 在之前 会返回 -1
        // 当前时间 对比 截止日期 在之后 会返回 1

//        int i = dateNow.compareTo(offsetDateTime);
//        System.out.println(i);
//        int abs = Math.abs(i);
//        OffsetDateTime offsetDateTime1 = dateNow.plusDays(abs);
//        System.out.println(offsetDateTime1);
//        int i1 = offsetDateTime.compareTo(dateNow);
//        System.out.println(i1);

//        OffsetDateTime offsetDateTime1 = dateNow.plusMinutes(40);
//        System.out.println(offsetDateTime1);


    }
}

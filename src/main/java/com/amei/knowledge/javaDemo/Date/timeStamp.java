package com.amei.knowledge.javaDemo.Date;

import java.text.SimpleDateFormat;
import java.util.*;

public class timeStamp {
    public static void main(String[] args) {
        //        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        System.out.println(dateFormat.format(date));

        System.out.println(System.currentTimeMillis());

        //俩个时间戳相差几分钟
        System.out.println((System.currentTimeMillis() - 1626757908956l) / (1000 * 60));

        //时间戳转化日期
//        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1626757954236l));
        String result1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(1626757954236l));
//        String result1 = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
        System.out.println("-------->   " + result1);

        //获取当前年月日
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");//设置当前时间的格式，为年-月-日
        System.out.println(dateFormat.format(new Date()));


        //对时间错进行排序
        ArrayList<Long> doubles = new ArrayList<>();
        doubles.add(1626761855991L);
        doubles.add(1626757908956L);
        System.out.println(doubles);
        Collections.sort(doubles);
        System.out.println(doubles);


        //0.0的时间戳,方式1
        //设置时区
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println("00000000000000000---------------------------0l");
        System.out.println(calendar.getTimeInMillis());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar.getTimeInMillis())));

        //0.0的时间戳,方式2
        Long currentTimestamps = System.currentTimeMillis();
        Long oneDayTimestamps = Long.valueOf(60 * 60 * 24 * 1000);
        System.out.println((currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date((currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps))));

        //
        /**
         * <获取当天23:59:59时间戳>
         *
         * @return 当天23:59:59时间戳
         * @throws
         */
        System.out.println(
                (currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps + 24 * 60 * 60 * 1000 - 1000)
        );
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date((currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps + 24 * 60 * 60 * 1000 - 1000))));

        //获取当前时间戳的月份
        calendar.setTimeInMillis(1627315200078L);
        System.out.println(new SimpleDateFormat("yyyy/MM").format(new Date(calendar.getTimeInMillis())));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1627545315850L)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1627553304147L)));

        System.out.println("========================");
        String monthBegin = getMonthBegin(new Date(1628494806341L));
        String monthEnd = getMonthEnd(new Date(1628494806341L));
        System.out.println(monthBegin);
        System.out.println(monthEnd);

        //时间戳转换时间秒
        new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
        System.out.println(getYesterdayDate());
    }

    /**
     * 获取当月的开始时间
     */
    public static String getMonthBegin(Date date) {
        SimpleDateFormat aDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        System.out.println(c.getTime());
        // 获取本月第一天的时间
        return aDateFormat.format(c.getTimeInMillis());
    }

    /**
     * 获取当月的结束时间
     */
    public static String getMonthEnd(Date date) {
        SimpleDateFormat aDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND, 59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间
        System.out.println(c.getTime());
        return aDateFormat.format(c.getTimeInMillis());
    }

    /**
     * 获取当月的第一天0。00
     */
    public static String getMonthFirstDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -2);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(c.DAY_OF_MONTH));
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        Date m = c.getTime();
        System.out.println(sdf.format(m));
        return sdf.format(m);

    }

//    public static void main(String[] args) {
//        getMonthFirstDay();
//    }

    /**
     * 获取当前时间，前一天的日期
     */
    public static Date getYesterdayDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date time = calendar.getTime();
        return time;
    }


}

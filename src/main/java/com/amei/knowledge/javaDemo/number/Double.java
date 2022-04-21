package com.amei.knowledge.javaDemo.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Double {
    public static void main(String[] args) {

        //double 保留俩位小数
        DecimalFormat df   = new DecimalFormat("######0.00");
        double d1 = 3.23456;
        double d2 = 0.0;
        double d3 = 2.0;
        String format = df.format(d1);
        df.format(d2);
        df.format(d3);
        System.out.println(format);

        //四舍五入
        BigDecimal b = new BigDecimal(1.7799999999999998);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
}

package com.amei.knowledge.算法题;

public class 整数反转 {
    public static void main(String[] args) {
        int x = 2147483647 ;
        int temp = 0;
        int res = 0;
        while (x != 0) {

            //2147483648
            if (res  > 214748364 || ((res / 10) == 214748364 && res % 10 > 8) || (res/10)>214748364) {
                System.out.println("--------"+0);
                break;
            } else if ((res / 10) < -214748364 || (res / 10) == -214748364 && res % 10 < -8) {
                System.out.println("======="+0);
                break;
            } else {
                System.out.println("¥¥¥¥¥¥¥¥¥¥¥"+res);
            }
            temp = x % 10;
            res = res * 10 + temp;
            x = x / 10;
        }
        System.out.println("@@@@@@res@@@@@@@@2"+res);

    }


}

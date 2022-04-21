package com.amei.knowledge.javaDemo.string;

import java.util.HashMap;
import java.util.Map;

public class StringDemo {
    public static void main(String[] args) {

        String s = "abcabcbb";
        //charAt下标是从0开始的；
        System.out.println(s.charAt(0));

        System.out.println(lengthOfLongestSubstring(s));

        String str = "com.ns.entity.object.form.instance.";
//        System.out.println(str.length());
        System.out.println(str.substring(0,35));
//        System.out.println(matchLike(str));
        System.out.println(str.substring(0,str.length()-1));
        System.out.println(333333333);
    }

    /**
     * map (k, v)，其中 key 值为字符，value 值为字符位置;
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                start = Math.max(map.get(element) + 1, start); //map.get()的地方进行+1操作
            }
            max = Math.max(max, end - start + 1);
            map.put(element, end);
        }
        return max;
    }


    /**
     * 字符串模糊匹配
     */
    public static int matchLike(String s) {
        int i = "com.ns.entity.object.form.instance.1472180271".indexOf(s, 0);
        return i;
    }
}

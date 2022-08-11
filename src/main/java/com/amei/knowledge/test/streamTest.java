package com.amei.knowledge.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class streamTest {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.stream().forEach(map -> {
//            list.add("6");
//        });

        ArrayList<Map> list = new ArrayList() {{
            add(new HashMap() {{
                put("id", "1");
                put("age", "10");
            }});
            add(new HashMap() {{
                put("id", "2");
            }});
            add(new HashMap() {{
                put("id", "3");
            }});
            add(new HashMap() {{
                put("id", "4");
            }});
        }};
        HashMap<String, List> stringListHashMap = new HashMap<String, List>();
        stringListHashMap.put("name", list);
        List<Map<String, String>> list1 = stringListHashMap.get("name");
        for (Map<String, String> map : list1) {
            for (String key : map.keySet()) {
                if (map.get(key).equals("1")) {
                    map.put("name", "mary");
                }
            }
//            map.put("name", "传递");
        }

        Map map = list1.get(0);
        for (Object key : map.keySet()) {
            if (map.get(key).equals("1")) {
                map.put("name", "mary");
            }
        }
    }
}

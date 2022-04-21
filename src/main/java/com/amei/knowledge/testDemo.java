package com.amei.knowledge;

import com.amei.knowledge.exception.GlobalException;
import com.amei.knowledge.testEntity.Attribute;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpStatus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class testDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//
//        Attribute attribute = new Attribute();
//        ObjectMapper objectMapper = new ObjectMapper();
//        //判断属性的子标签是否完整
//        //校验必填标签
//        List<String> defect = new ArrayList<>();
//
//        Method[] methods = attribute.getClass().getMethods();
//        for (Method method:methods){
//            method.invoke(attribute, UUID.randomUUID().toString());
//            System.out.println(attribute.getCategory_id());
//        }

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        c.set(Calendar.MINUTE, 59);
        //将秒至0
        c.set(Calendar.SECOND, 59);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 999);
        // 获取当天的开始时间
        System.out.println(c.getTimeInMillis());
    }
}

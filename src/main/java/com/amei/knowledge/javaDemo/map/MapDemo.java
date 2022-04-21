package com.amei.knowledge.javaDemo.map;

import com.amei.knowledge.testEntity.Attribute;

import java.lang.reflect.Method;
import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {

        Attribute attribute = new Attribute();
        HashMap<String, Method> methodHashMap = getMap(attribute.getClass());
        //遍历方法1：
        // 循环entry遍历
        for (HashMap.Entry<String, Method> entry : methodHashMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        //遍历方法2：
        //循环key
        for (String filedName:methodHashMap.keySet()){
            System.out.println(filedName+"    :"+methodHashMap.get(filedName));
        }
    }


    /**
     *
     * @param entityClass
     * @return  属性-方法   username  String
     *
     */
    //得到Map
    public static HashMap<String, Method> getMap(Class<?> entityClass){
        Method[] methods = entityClass.getMethods();
        HashMap<String, Method> hashMap = new HashMap<>();
        for (Method method:methods) {
            String methodName = method.getName();
            if (methodName.startsWith("set"))
                hashMap.put(methodName.replace("set","").toLowerCase(),method);
        }
        return hashMap;
    }

}

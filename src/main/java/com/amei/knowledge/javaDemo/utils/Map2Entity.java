//package com.amei.knowledge.java.utils;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.HttpStatus;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.Map;
//
//public class Map2Entity {
//    public static void main(String[] args) {
//
//    }
//
//    /**
//     * hashmap对象set进属性对象中
//     *
//     * @param entity      待更新实体类
//     * @param setMap      更新HashMap
//     * @param updateField 要更新的字段列表
//     * @return 待更新属性
//     */
//    private <T> T setAttributeFiled(T entity, Map<String, Object> setMap, String[] updateField)  {
//        Map<String, Method> setMethodMap = this.getEntityMethodMap(entity.getClass());
//        Arrays.sort(updateField);
//        for (String fieldName : setMap.keySet()) {
//            if (setMethodMap.get(fieldName) == null || Arrays.binarySearch(updateField, fieldName) < 0)
//                continue;
//            Method setMethod = setMethodMap.get(fieldName);
//            String valueElement = setMap.get(fieldName).toString();
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                switch (setMethod.getParameterTypes()[0].getName()) {
//                    case "java.lang.String":
//                        setMethod.invoke(entity, valueElement);
//                        break;
//                    case "int":
//                        setMethod.invoke(entity, Integer.parseInt(valueElement));
//                        break;
//                    case "java.util.Map":
//                        if (valueElement.length() == 0) {
//                            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, fieldName + "字段,空值");
//                        }
//                        valueElement = valueElement.replaceAll("\\s*", "").replace(",]", "]").replace(",}", "}");
//                        setMethod.invoke(entity, objectMapper.readValue(valueElement, Map.class));
//                        break;
//                    case "boolean":
//                        setMethod.invoke(entity, Boolean.valueOf(valueElement));
//                        break;
//                    case "long":
//                        setMethod.invoke(entity, Long.valueOf(valueElement));
//                        break;
//                    default:
//                        System.out.println("无效的模板类型：" + setMethod.getParameterTypes()[0].getName());
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//                throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, fieldName + "项" + e.getMessage());
//            } catch (
//                    InvocationTargetException e) {
//                e.printStackTrace();
//                throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, fieldName + "项" + e.getMessage());
//            } catch (
//                    JsonProcessingException e) {
//                e.printStackTrace();
//                throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, fieldName + "项不符合json要求");
//            }
//        }
//        return entity;
//    }
//
//
//}

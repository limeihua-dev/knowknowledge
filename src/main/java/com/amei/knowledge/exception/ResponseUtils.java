package com.amei.knowledge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API接口统一返回处理工具类
 *
 * @author zhangzhuang
 */
public class ResponseUtils {
    /**
     * 接口成功返回
     * 用于 删除 & 更新 成功操作
     *
     * @return ResponseEntity<Object>
     */
    public static ResponseEntity<Void> success(HttpStatus httpStatus) {
        return new ResponseEntity<Void>(httpStatus);
    }

    /**
     * 接口成功返回
     * 用于 新增 & 查询 成功操作
     *
     * @return ResponseEntity<Object>
     */
    public static <T> ResponseEntity<T> success(T obj, HttpStatus httpStatus) {
        return new ResponseEntity<T>(obj, httpStatus);
    }
    public static <T> ResponseEntity<List<T>> success(List<T> obj, HttpStatus httpStatus) {
        return new ResponseEntity<List<T>>(obj, httpStatus);
    }
    public static <K,V> ResponseEntity<Map<K,V>> success(Map<K,V> obj, HttpStatus httpStatus) {
        return new ResponseEntity<Map<K,V>>(obj, httpStatus);
    }


    /**
     * 接口失败返回
     *
     * @param httpStatus http状态码
     * @return ResponseEntity<Object>
     */
    public static ResponseEntity<Object> error(HttpStatus httpStatus) {
        return new ResponseEntity<Object>(httpStatus);
    }

    /**
     * 接口失败返回
     *
     * @param httpStatus http状态码
     * @param desc       自定义报错描述信息
     * @return ResponseEntity<Object>
     */
    public static ResponseEntity<Object> error(HttpStatus httpStatus, String desc) {
        HashMap<String, String> errorMessage = new HashMap<>();
        errorMessage.put("error", httpStatus.getReasonPhrase());
        errorMessage.put("desc", desc);
        return new ResponseEntity<Object>(errorMessage, httpStatus);
    }
}

//package com.amei.knowledge.springboot.async;
//
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//
//import java.lang.reflect.Method;
//
///**
// * 当方法返回类型为Future时，异常处理很容易– Future.get()方法将抛出异常。
// * 但是如果是无返回值的异步方法，异常不会传播到调用线程。因此，我们需要添加额外的配置来处理异常。
// * 我们将通过实现AsyncUncaughtExceptionHandler接口来创建自定义异步异常处理程序。
// * 当存在任何未捕获的异步异常时，将调用handleUncaughtException()方法：
// */
//public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
//    @Override
//    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
//        System.out.println("Exception message - " + throwable.getMessage());
//        System.out.println("Method name - " + method.getName());
//        for (Object param : objects) {
//            System.out.println("Parameter value - " + param);
//        }
//    }
//}

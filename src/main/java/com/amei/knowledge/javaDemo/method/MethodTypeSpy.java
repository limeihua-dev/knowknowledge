package com.amei.knowledge.javaDemo.method;

import com.amei.knowledge.testEntity.Attribute;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class MethodTypeSpy extends Attribute {

    private static final String HELLO_WORLD = "I'm cute shixin";

    @Deprecated
    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("得到本类中的类名----->"+ new MethodTypeSpy().getClass().getCanonicalName());

        Method[] declaredMethods = Attribute.class.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println( "Method name -------> "   + declaredMethod.getName()+" \n\n");  //获得单独的方法名
            //获得完整的方法信息（包括修饰符、返回值、路径、名称、参数、抛出值）
            System.out.println( "toGenericString -------->   "+ declaredMethod.toGenericString()+"\n\n");

            System.out.println( "Modifiers:    -------->    "+  Modifier.toString(declaredMethod.getModifiers())+"\n\n");

            System.out.format( "ReturnType -------->  "+ declaredMethod.getReturnType() +"\n\n");   //获得返回值
            System.out.format( "getGenericReturnType -------->   "+ declaredMethod.getGenericReturnType()+"\n\n");//获得完整信息的返回值

            Class<?>[] parameterTypes = declaredMethod.getParameterTypes(); //获得参数类型
            Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.format( "ParameterType###################3 -------->  "+parameterTypes[i].getName()+"\n\n");
                System.out.format( "GenericParameterType -------->  "+ genericParameterTypes[i]+"\n\n");
            }

            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();     //获得异常名称
            Type[] genericExceptionTypes = declaredMethod.getGenericExceptionTypes();
            for (int i = 0; i < exceptionTypes.length; i++) {
                System.out.format( "ExceptionTypes -------->  "+exceptionTypes[i]+"\n\n");
                System.out.format( "GenericExceptionTypes -------->  "+genericExceptionTypes[i]+"\n\n");
            }

            Annotation[] annotations = declaredMethod.getAnnotations(); //获得注解
            for (Annotation annotation : annotations) {
                System.out.format( "Annotation  -------->  "+ annotation+"\n\n");
                System.out.format( "AnnotationType -------->  "+annotation.annotationType()+"\n\n");
            }
        }
    }
}

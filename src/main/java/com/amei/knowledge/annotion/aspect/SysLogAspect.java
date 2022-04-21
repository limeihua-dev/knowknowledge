package com.amei.knowledge.annotion.aspect;

import com.amei.knowledge.annotion.Log;
import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;

import static java.lang.Character.LINE_SEPARATOR;

@Aspect
@Component
public class SysLogAspect {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogAspect.class);


    @Pointcut("@annotation(com.amei.knowledge.annotion.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 目标方法
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        LOGGER.info("cdcdcddfvfbgbg: {}",new Gson().toJson(result));
        //执行耗时
        LOGGER.info("cdcdcddfvfbgbg: {}",System.currentTimeMillis()-beginTime);
        return result;
    }


    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取 @WebLog 注解的描述信息
//        String methodDescription = getAspectLogDescription(joinPoint);

        // 打印请求相关参数
        LOGGER.info("========================================== Start ==========================================");
        // 打印请求 url
        LOGGER.info("URL            : {}", request.getRequestURL().toString());
        // 打印描述信息
//        LOGGER.info("Description    : {}", methodDescription);
        // 打印 Http method
        LOGGER.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        LOGGER.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        LOGGER.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        LOGGER.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
    }


    @After("logPointCut()")
    public void doAfter() throws Throwable {
        // 接口结束后换行，方便分割查看
        LOGGER.info("=========================================== End ===========================================" + LINE_SEPARATOR);
    }

    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(Log.class).value());
                    break;
                }
            }
        }
        return description.toString();
    }




}


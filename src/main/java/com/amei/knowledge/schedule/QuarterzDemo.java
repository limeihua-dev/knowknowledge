package com.amei.knowledge.schedule;

import org.quartz.*;
import org.springframework.stereotype.Component;
import xin.altitude.cms.quartz.annotation.CronExp;

import java.time.LocalDateTime;

/**
 * 快速上手
 * <p>
 * 第一步：实现job接口
 * 第二步：使用注解CronExp，添加任务的调度策略
 * 第三步：使用注解将任务注入容器
 * 启动项目，项目就处于监听与运行中
 */
//@CronExp(id = 1, cron = "0 0/1 * * * ? ")
//@Component
@DisallowConcurrentExecution
public class QuarterzDemo implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //任务的具体执行内容
        System.out.println(" 任务一： " + LocalDateTime.now());
        //如果在调用任务时传递参数；则能够从Map中获取
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        Object key = jobDataMap.get("key");
        System.out.println(" 任务一： " + LocalDateTime.now() + "  "+key);
    }
}

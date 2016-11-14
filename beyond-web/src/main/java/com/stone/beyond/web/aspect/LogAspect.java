package com.stone.beyond.web.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by stone on 2016/11/14.
 */
@Aspect
@Component
public class LogAspect {

    private Logger Log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 切入点
     */
    @Pointcut(value = "execution (* com.stone.beyond.web.handler..*.*(..))")
    public void pointcut() {
    }


    @Around(value = "com.stone.beyond.web.aspect.LogAspect.pointcut()")
    public Object process(ProceedingJoinPoint jp) throws java.lang.Throwable {
        Object rvt;
        long startTime = System.currentTimeMillis();
        String methodInfo = jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName();
        Log.info("调用方法:" + methodInfo);
        rvt = jp.proceed();
        long endTime = System.currentTimeMillis();
        String returnInfo = JSON.toJSONString(rvt);
        long time = endTime - startTime;
        Log.info("{调用方法:" + methodInfo + ",  返回值:" + returnInfo + ",  耗时:" + time + "毫秒}");
        return rvt;
    }
}

package com.terrydr.common.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.terrydr.common.annotation.OperatorLog;
import com.terrydr.common.domain.Response;
import com.terrydr.common.utils.HttpUtils;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.domain.PlatformLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.aspect
 * @Description: Log注解的切面
 * @author: YanZhengYuan
 * @Date: 2018/6/28 17:01
 * @version: 1.00
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.terrydr.common.annotation.OperatorLog)")
    public void logPointCut() {
    }


    @Around(value="logPointCut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point, time, result);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time, Object result) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        PlatformLog logToSave = new PlatformLog();
        // 注解
        OperatorLog syslog = method.getAnnotation(OperatorLog.class);
        if (syslog != null) {
            if(OSSContext.isAuthenticated()){
                logToSave.setOperationDesc(OSSContext.getCurrentUser().getUserRealName() + syslog.desc());
            }else{
                logToSave.setOperationDesc(syslog.desc());
            }
            logToSave.setScope(syslog.scope());
            logToSave.setScopeName(OSSContext.getPlatformMenuService().getMenuNameById(syslog.scope()));
            logToSave.setType(syslog.type());
        }
        // 执行时间
        logToSave.setMillionsTaken(time);
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logToSave.setMethodName(className + "." + methodName + "()");
        // 返回的主键ID
        if(result != null && result instanceof Response){
            Response response = (Response)result;
            String returnObj = response.getResponseObject() != null ? response.getResponseObject().getId().toString() : "";
            logToSave.setDataId(returnObj);
        }
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            logToSave.setParams(Arrays.toString(args));
        } catch (Exception e) {
            logger.error("获取请求参数失败", e);
        }
        // 获取request
        HttpServletRequest request = OSSContext.getHttpServletRequest();
        // 设置IP地址
        logToSave.setIp(HttpUtils.getIpAddr(request));
        // 保存系统日志
        OSSContext.getPlatformLogService().saveLog(logToSave);
    }

}

package com.terrydr.common.aspect;

import com.terrydr.common.utils.HttpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.aspect
 * @Description: Controller层访问日志记录切面
 * @author: YanZhengYuan
 * @Date: 6/14/2018 7:25 PM
 * @version: 1.00
 */
@Aspect
@Component
public class BackLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(BackLogAspect.class);

    @Pointcut("execution( * com.terrydr..controller.*.*(..))")
    public void logPointCut() {
    }


    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null){
            HttpServletRequest request = attributes.getRequest();

            // 记录下请求内容
            logger.info("请求地址 : " + request.getRequestURL().toString());
            logger.info("SessionId : " + request.getSession().getId());
            logger.info("HTTP METHOD : " + request.getMethod());
            // 获取真实的ip地址
            logger.info("IP : " + HttpUtils.getIpAddr(request));
            logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName());
            logger.debug("参数 : " + Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) {
        logger.debug("返回值 : " + ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }

}

package com.surfur.ssm.pointcut;

import com.surfur.ssm.annotation.OperationLog;
import com.surfur.ssm.common.LogScheme;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// 声明该类为切面类
@Aspect
// 声明为组件
@Component
// 值越小越先执行
@Order(1)
public class LogAspect {

    @Pointcut(value = "@annotation(com.surfur.ssm.annotation.OperationLog)")
    // @Pointcut(value = "execution(* com.surfur.ssm.controller.EmpController.findListPage(..))")
    public void OperationLogPointCut() {
    }

    @Around(value = "OperationLogPointCut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        OperationLog annotation = method.getDeclaredAnnotation(OperationLog.class);
        LogScheme.OperationType operationType = annotation.type();
        String target = annotation.target();

        System.out.println("操作目标 = " + target);

        Integer value = operationType.getValue();
        String message = operationType.getMessage();
        System.out.println("操作类型：" + value + "_" + message);

        String content = annotation.content();
        System.out.println("操作内容：" + content);

        // 统计当前接口耗时时间
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        System.out.println("接口耗时时间：" + (endTime - startTime) + "毫秒");

        return proceed;
    }

}

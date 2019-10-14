package com.ctillnow.ascept;

import com.ctillnow.myannotation.PrintLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by caiping on 2019/10/12.
 *切面类
 */

@Aspect
@Component
public class PrintLogAscept {
    @Pointcut("@annotation(com.ctillnow.myannotation.PrintLog)")
    public void  annotationPointcut() {

    }
    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println(request.getRequestURL());
        System.out.println(request.getRemoteAddr());

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        PrintLog printLog = method.getAnnotation(PrintLog.class);
        String value = printLog.value();
        System.out.println("准备"+value);

    }


    @After("annotationPointcut()")
    public void afterPointCut(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        PrintLog printLog = method.getAnnotation(PrintLog.class);
        String value = printLog.value();
        System.out.println("结束"+value);
    }

    @Around(value = "annotationPointcut()")
    public Object AroundCall(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("--------环绕通知start-------");
        String typeName = joinPoint.getTarget().getClass().getName();
        System.out.println("--------目标对象{},"+typeName+"-------");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("------所切方法名"+methodName+"-----");
        Object result = joinPoint.proceed();
        System.out.println("--------环绕通知结束--------");
        return result;
    }

    @After(value = "annotationPointcut()")
    public void AfterCall(){
        System.out.println("后置通知");
    }
    @AfterReturning(value = "annotationPointcut()")
    public void AfterReturnCall(){
        System.out.println("返回通知");

    }

    @AfterThrowing(value = "annotationPointcut()")
    public void AfterThrowingCall(){
        System.out.println("异常通知");

    }
}

package com.findeng.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FunctionLog {

    //Service层切点
    @Pointcut("execution(* com.findeng.mvc.serviceimpl..*.*(..))")
    public void serviceAspect() {

    }

    //前置通知
    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint) {
    	/* for (int i = 0; i < joinPoint.getArgs().length; i++) {  
             System.out.println("方法参数:"+joinPoint.getArgs()[i]);  
         }  
         System.out.println("方法名:"+joinPoint.getSignature().getName());*/
    }

    //后置通知
    @After("serviceAspect()")
    public void doAfter(JoinPoint joinPoint) {
   	/* for (int i = 0; i < joinPoint.getArgs().length; i++) {  
            System.out.println("方法参数:"+joinPoint.getArgs()[i]);  
        }  
        System.out.println("方法名:"+joinPoint.getSignature().getName());*/
    }
}

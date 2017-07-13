package com.example.demo.service.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.demo.annotation.Action;

@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(com.example.demo.annotation.Action)")
	public void annotationPointCut() {
	}

	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println(action.name());
	}

	@Before("execution(* com.example.demo.service.aop.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		
		System.out.println("拦截方法 " + method.getName());
	}
	
	@Around("execution(* com.example.demo.service.aop.DemoMethodService.*(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("around拦截前");
		proceedingJoinPoint.proceed();
		System.out.println("around拦截后");
		
	}

}

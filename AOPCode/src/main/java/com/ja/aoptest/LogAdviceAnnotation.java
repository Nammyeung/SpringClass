package com.ja.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class LogAdviceAnnotation {
	
	
	@Pointcut("execution(* com.ja.aoptest..*Impl.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void printLog(JoinPoint jp) {
		System.out.println(jp.getSignature().getName());
	}
	
//	@Pointcut("execution(* com..*Impl.*(..))")
//	public void xxxx() {}
//		
//	@Before("xxxx()")
//	public void printLog(JoinPoint jp) {
//		System.out.println(jp.getSignature().getName());
//	}
	
}


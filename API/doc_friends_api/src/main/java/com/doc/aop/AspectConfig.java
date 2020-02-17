package com.doc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AspectConfig {

	@Around("execution(* com.doc.service.*.*(..))")
	public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable{
		log.info("[start] - " + pjp.getSignature().getName());
		Object result = null;
		try {
			result = pjp.proceed();
		}catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("[end] - " + pjp.getSignature().getName());
		return result;
	}

}

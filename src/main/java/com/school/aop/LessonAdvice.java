package com.school.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LessonAdvice {
	
	@Pointcut("execution(* com.school.dao..*(..))")
	private void lessonPt() {}
	
	@Around("lessonPt()")
	public Object trimStr(ProceedingJoinPoint pjt) throws Throwable {
		
		Object[] args = pjt.getArgs();
		for (int i = 0; i < args.length; i++) {
			if (args[i].getClass().equals(String.class)) {
				args[i] = args[i].toString().trim();
			}
		}
		
		Object ret = pjt.proceed(args);
		return ret;
	}
}

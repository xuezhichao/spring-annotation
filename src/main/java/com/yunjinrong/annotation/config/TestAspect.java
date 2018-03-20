package com.yunjinrong.annotation.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

	@Pointcut("execution(public * com.yunjinrong.annotation.web.AnnotationController.add*(..)) && @annotation(com.yunjinrong.annotation.config.MyAnnotation)")
	public void addAdvice() {
		
		System.out.println("123");
	}
	
	@Around("addAdvice()")
	public Object interceptor(ProceedingJoinPoint pjp) {
		System.out.println("环绕通知start");
		Object result=null;

		Object[] args = pjp.getArgs();
		if(args != null && args.length>0) {
			String deviceId = (String)args[0];
			if(!"03".equals(deviceId)) {
				System.out.println("环绕通知end");
				return "no anthorization";
			}
		}
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("环绕通知end");
		return result;
	}
}

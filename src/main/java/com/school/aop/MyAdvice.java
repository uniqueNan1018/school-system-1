package com.school.aop;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	/*
	 * Pointcut
	 * execution 指示式
	 * 指示式    (戻り値 パッケージ　    型、クラス メソッド 引数）
	 * execution(* com.example.domin.*Service.find*(..))
	 * 
	 * Pointcut式で利用可能なワイルドガード
	 * "*"  基本的に任意の文字列を表すが、パッケージを表す場合は、任意なパッケージ1階層を表す。
	 * 　　　メソッドの引数を表す場合は、一つの数の引数を表す
	 * 　　　public * com.example.*.UserService.find*(*)
	 * 
	 * ".." パッケージを表す場合は、任意の（0以上）パッケージを表す。
	 * 　　　メソッドの引数を表現する場合は、任意の（0以上）の数の引数を表す
	 *      public User com..UserService.findById(..)
	 *      
	 * "+"　クラス名の後に指定することになり、そのクラスとそのサブクラス/実装クラスすべてを表す
	 *      execution(* *..*Service+.*(..))
	 */
	@Pointcut("execution(void com.school.dao.impl.*.update())")
	private void pt() {}
	
	@Pointcut("execution(* com.school.dao.impl.*.delete())")
	private void ptDel() {}
	
	@Pointcut("execution(* com.school.dao.*.*(..))")
	private void ptOfProd() {}
	
//	@Before("pt()")
	public void printTime() {
		LocalDateTime t1 = LocalDateTime.now();
		System.out.println(t1);
	}
	
	@Before("ptOfProd()")
	public void before(JoinPoint jp) {
		System.out.println("before advice...");
		Object[] args = jp.getArgs();
		System.out.println(Arrays.toString(args)); 
	}
//	@After("pt()")
	public void after() {
		System.out.println("after advice...");
	}
	
//	@Around("pt()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before advice...");
		/*
		 * 元のメソッドを呼び出す
		 */
		pjp.proceed();
		System.out.println("around after advice...");
	}
	
//	@Around("ptDel()")
	public Object aroundDel(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before advice...");
		/*
		 * 元のメソッドを呼び出す
		 */
		Object ret = pjp.proceed();
		System.out.println("around after advice...");
		return ret;
	}
	
//	@Around("ptOfProd()")
	public Object prodRecord(ProceedingJoinPoint pjp) throws Throwable {
		Long startTime = System.currentTimeMillis();
		Object ret = null;
		for (int i = 0; i < 10000; i++) {
			ret = pjp.proceed();
		}
		Signature signature = pjp.getSignature();
		String className = signature.getDeclaringType().toString();
		String methodName = signature.getName();
		Long endTime = System.currentTimeMillis();
		Long time = endTime - startTime;
		System.out.println("10000回 " + className + "の" + methodName + "実行する必要な時間は" + time + "ms");
		return ret;
	}
	
	/*
	 * メソッドが正常に実行終わった時、実行する
	 */
//	@AfterReturning("ptDel()")
	public void afterReturning() {
		System.out.println("afterReturning advice...");
	}
	
	/*
	 * メソッドが例外をスローした時、実行する
	 */
//	@AfterThrowing("ptDel()")
	public void afterThrowing() {
		System.out.println("afterThrowing advice...");
	}
}

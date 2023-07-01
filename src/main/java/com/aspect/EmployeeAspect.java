package com.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.entity.Employee;

@Aspect
@Component
public class EmployeeAspect {
	// class becomes an aspect
	// all methods become advice
	// execution(* com.controller.EmployeeController.*(..) --> pointcut expression
	// specifying where it has to be implemented
	// execution of (what is the return type of that method, what is that method)
	// over (fully qualified )EmployeeController class, all methods of
	// EmployeeController having any number of parameters (*)

//	CLASS --> ASPECT
//	METHOD --> ADVICE
//	EXPRESSION --> POINTCUT
//	JOINPOINTS --> execution of flow where point cut can be plugged in

	@Before(value = "execution(* com.controller.EmployeeController.*(..))") // --> pointcut expression
	public void beforeAdvice(JoinPoint joinPoint) { // --> Join Point business logic where advice is implemented
		System.out.println("Request to" + joinPoint.getSignature() + " started at " + new Date());
	}

	@After(value = "execution(* com.controller.EmployeeController.*(..))") // --> pointcut expression
	public void afterAdvice(JoinPoint joinPoint) { // --> Join Point business logic where advice is implemented
		System.out.println("Request to" + joinPoint.getSignature() + " ended at " + new Date());
	}

	@Before(value = "execution(* com.service.EmployeeService.*(..))") // --> pointcut expression
	public void beforeAdviceServiceLayer(JoinPoint joinPoint) { // --> Join Point business logic where advice is
																// implemented
		System.out.println("Request to" + joinPoint.getSignature() + " started at Service layer " + new Date());
	}

	@After(value = "execution(* com.service.EmployeeService.*(..))") // --> pointcut expression
	public void afterAdviceServiceLayer(JoinPoint joinPoint) { // --> Join Point business logic where advice is
																// implemented
		System.out.println("Request to" + joinPoint.getSignature() + " ended at Service layer " + new Date());
	}

	@AfterReturning(value = "execution(* com.service.EmployeeService.save(..))", returning = "employee") // --> pointcut
	public void afterReturningAdviceServiceLayer(JoinPoint joinPoint, Employee employee) {
		System.out.println(
				"Request to" + joinPoint.getSignature() + " ended at Service layer, employee returned" + employee);
	}

	@AfterThrowing(value = "execution(* com.service.EmployeeService.save(..))", throwing = "exception") // --> pointcut
	public void afterReturningAdviceServiceLayer(JoinPoint joinPoint, Exception exception) {
		System.out.println(
				"Request to" + joinPoint.getSignature() + " ended at Service layer, excepion thrown " + exception);
	}

}

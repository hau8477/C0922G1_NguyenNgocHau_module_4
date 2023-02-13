package com.example.bookmanagement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {
    @Pointcut("execution(* com.example.bookmanagement.controller.BookController.borrowBook(..))||execution(* com.example.bookmanagement.controller.BookController.returnBook(..))")
    public void getMethodBookController() {
    }

    @After(value = "getMethodBookController()")
    public void printConsoleBook(JoinPoint joinPoint) {
        System.out.println("Bạn đã vào phương thức " + joinPoint.getSignature().getName() + " vào lúc : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.bookmanagement.controller.BookController.*(..))||execution(* com.example.bookmanagement.controller.BorrowerController.*(..))")
    public void getAllMethod() {
    }

    @Before(value = "getAllMethod()")
    public void printConsoleLibrary() {
        System.out.println("Bạn đã vào thư viện vào lúc : " + LocalDateTime.now());
    }
}

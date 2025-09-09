package com.ecommerce.aop;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

    public void logBefore(JoinPoint joinPoint) {
        String service = joinPoint.getTarget().getClass().getSimpleName();

        if (service.contains("Product")) {
            System.out.println("Starting product operation...");
        } else if (service.contains("Order")) {
            System.out.println("Processing order...");
        } else if (service.contains("Payment")) {
            System.out.println("Handling payment...");
        } else {
            System.out.println("Action started...");
        }
    }

    public void logAfter(JoinPoint joinPoint) {
        String service = joinPoint.getTarget().getClass().getSimpleName();

        if (service.contains("Product")) {
            System.out.println("Product operation completed.");
            System.out.println("---------------------------------");
        } else if (service.contains("Order")) {
            System.out.println("Order processed successfully.");
            System.out.println("---------------------------------");
        } else if (service.contains("Payment")) {
            System.out.println("Payment completed.");
            System.out.println("---------------------------------");
        } else {
            System.out.println("Action completed.");
            System.out.println("---------------------------------");
        }
    }
}

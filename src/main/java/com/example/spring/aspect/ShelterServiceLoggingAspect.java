package com.example.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ShelterServiceLoggingAspect
{
   private static final Logger LOGGER =
            LoggerFactory.getLogger(ShelterServiceLoggingAspect.class);

   @Pointcut("within(com..DefaultShelterService) && execution(public * *(..))")
   public void shelterServicePublicMethods()
   {

   }

   @Before("shelterServicePublicMethods()")
   public void beforeLogHandler(final JoinPoint joinPoint)
   {
      LOGGER.debug("Starting method execution: {}", joinPoint.toShortString());
   }

   @After("shelterServicePublicMethods()")
   public void afterLogHandler(final JoinPoint joinPoint)
   {
      LOGGER.debug("Ending method execution: {}", joinPoint.toShortString());
   }

   @AfterReturning(value = "shelterServicePublicMethods()", returning = "value")
   public void afterReturningLogHandler(final Object value)
   {
      LOGGER.debug("Returned value: {}", value);
   }
}

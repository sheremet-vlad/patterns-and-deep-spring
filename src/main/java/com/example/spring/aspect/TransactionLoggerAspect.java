package com.example.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionLoggerAspect
{
   private static final Logger LOGGER =
            LoggerFactory.getLogger(TransactionLoggerAspect.class);

   @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
   public Object logTransactionStatus(final ProceedingJoinPoint proceedingJoinPoint)
   {
      try
      {
         LOGGER.debug("transaction started");
         return proceedingJoinPoint.proceed();
      }
      catch (Throwable throwable)
      {
         throwable.printStackTrace();
      }
      finally
      {
         LOGGER.debug("transaction ended");
      }
      return null;
   }
}

package com.example.spring.beanpostprocessor;

import com.example.spring.annotation.Profiling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class ProfilerAnnotationBeanPostProcessor implements BeanPostProcessor
{
   private static final Logger LOGGER =
            LoggerFactory.getLogger(ProfilerAnnotationBeanPostProcessor.class);

   @Value("${profiling.enabled}")
   private boolean profilingEnabled;

   private final Map<String, Class<?>> map = new HashMap<>();

   @Override
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
   {
      final Class<?> beanClass = bean.getClass();
      if (beanClass.isAnnotationPresent(Profiling.class))
      {
         map.put(beanName, beanClass);
      }
      return bean;
   }

   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
   {
      Class<?> beanClass = map.get(beanName);

      if (Objects.nonNull(beanClass))
      {
         return createProxy(bean, beanClass);
      }

      return bean;
   }

   private Object createProxy(Object bean, Class<?> beanClass)
   {
      return Proxy.newProxyInstance(beanClass.getClassLoader(),
               beanClass.getInterfaces(),
               (proxy, method, args) -> createInvocationHandler(bean, method, args));
   }

   private Object createInvocationHandler(Object bean, final Method method,
            final Object[] args) throws InvocationTargetException, IllegalAccessException
   {
      if (profilingEnabled)
      {
         return executeMethodWithProfiling(bean, method, args);
      }
      else
      {
         return method.invoke(bean, args);
      }
   }

   private Object executeMethodWithProfiling(final Object bean, final Method method,
            final Object[] args) throws InvocationTargetException, IllegalAccessException
   {
      LOGGER.info("Profiling of method {} started", method);
      long before = System.currentTimeMillis();
      Object value = method.invoke(bean, args);
      LOGGER.info("Execution time: {}", System.currentTimeMillis() - before);
      LOGGER.info("Profiling ended");

      return value;
   }
}

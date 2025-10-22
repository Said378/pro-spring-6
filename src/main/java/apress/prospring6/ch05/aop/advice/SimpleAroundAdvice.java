package apress.prospring6.ch05.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleAroundAdvice implements MethodInterceptor {

    Logger logger = LoggerFactory.getLogger(SimpleAroundAdvice.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        logger.info(">> Invoking " + invocation.getMethod().getName());

        Object returnValue = invocation.proceed();
        logger.info(">> Done ");

        return returnValue;
    }
}

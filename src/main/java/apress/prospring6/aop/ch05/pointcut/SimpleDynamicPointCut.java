package apress.prospring6.aop.ch05.pointcut;

import apress.prospring6.aop.ch05.target.GoodGuitarist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointCut extends DynamicMethodMatcherPointcut {

    Logger logger = LoggerFactory.getLogger(SimpleDynamicPointCut.class);

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "sign".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return cls-> (cls == GoodGuitarist.class);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args){
        logger.info("Dynamic check for " + method.getName());

        if(args.length == 0){
            return false;
        }

        var key = (String)args[0];

        return key.equalsIgnoreCase("C");
    }
}

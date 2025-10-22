package apress.prospring6.ch05.aop.pointcut;

import apress.prospring6.ch05.aop.target.GoodGuitarist;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointCut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "sign".equals(method.getName());
    }

    @Override
   public ClassFilter getClassFilter(){
        return cls -> (cls == GoodGuitarist.class);
    }
}

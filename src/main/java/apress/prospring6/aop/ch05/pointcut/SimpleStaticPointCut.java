package apress.prospring6.aop.ch05.pointcut;

import apress.prospring6.aop.ch05.target.GoodGuitarist;
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

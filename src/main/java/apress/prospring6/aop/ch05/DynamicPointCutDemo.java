package apress.prospring6.aop.ch05;

import apress.prospring6.aop.ch05.advice.SimpleAroundAdvice;
import apress.prospring6.aop.ch05.pointcut.SimpleDynamicPointCut;
import apress.prospring6.aop.ch05.target.GoodGuitarist;
import apress.prospring6.aop.ch05.target.Singer;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;


public class DynamicPointCutDemo {

    public static void main(String[] args) {

        GoodGuitarist target = new GoodGuitarist();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointCut(), new SimpleAroundAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        Singer proxy = (Singer)  proxyFactory.getProxy();

        proxy.sign("C");
        proxy.sign("c");
        proxy.sign("E");

        proxy.sign();
    }

}
